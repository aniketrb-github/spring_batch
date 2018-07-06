package com.techprimers.springbatchexample1.config;

import com.techprimers.springbatchexample1.customizedItemReaders.ConnectBookReader;
import com.techprimers.springbatchexample1.customizedItemReaders.RESTUserReader;
import com.techprimers.springbatchexample1.dto.ConnectBooksResponseDTO;
import com.techprimers.springbatchexample1.dto.UserDTO;
import com.techprimers.springbatchexample1.model.User;

import java.util.Collections;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

	/** --------------------------------- JOB : TO READ CSV FILE & LOAD DATA TO H2 DB -------------------- */
	/*
    @Bean
    public Job csvJob (JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<User> itemReader,
                   ItemProcessor<User, User> itemProcessor,
                   ItemWriter<User> itemWriter
    ) {

        Step step = stepBuilderFactory.get("ETL-csv-file-load")	// step name
                .<User, User>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();


        return jobBuilderFactory.get("ETL-csv-to-H2DB-Load")	// job name
                .incrementer(new RunIdIncrementer())
                .start(step)	// job has 1 step
                .build();
    }

    // ItemReader for reading the CSV file
    @Bean
    public FlatFileItemReader<User> itemReader() {

        FlatFileItemReader<User> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new ClassPathResource("users.csv"));	// what resource its gonna work upon
        flatFileItemReader.setName("CSV-Reader");	// the name of this reader
        flatFileItemReader.setLinesToSkip(1);		// lines to skip on any kind of failer(ex. can skip headers from csv)
        flatFileItemReader.setLineMapper(lineMapper());	// line mapper defined below
        return flatFileItemReader;
    }

    @Bean
    public LineMapper<User> lineMapper() {

        DefaultLineMapper<User> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(new String[]{"id", "name", "dept", "salary"});

        BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(User.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;
    }
    */
	
	
	
    /** ---------------------- JOB : TO CONSUME EXTERNAL API ----------------------------------- */
    
	
    @Primary
    @Bean
    public Job processUserDataJob (JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<UserDTO> restStudentReader,
                   ItemProcessor<UserDTO, UserDTO> itemProcessor,
                   ItemWriter<UserDTO> itemWriter
    ) {

        Step step = stepBuilderFactory.get("ReST-API-UserData")	// step name
                .<UserDTO, UserDTO> chunk(10)
                .reader(restStudentReader)	// here is our setp to consume the ReST API
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();


        return jobBuilderFactory.get("ReST-API-UserDataLoadJob")	// job name
                .incrementer(new RunIdIncrementer())
                .start(step)	// job has 1 step
                .build();
    }
    
    // Customized Item Reader to Consume an External API
    /**
     * Just Uncomment either of the environment properties(but finally u need to keep only one into the Constructor)
     * "get.user.for.id.url" is the API where we have used the HTTP HEADER METHOD THAT we will be using while invoking the connect v4 API
     * so follow this "get.user.for.id.url" only so as to get idea 
     * just try to integrate & replicate this logic with proper job names step names & method names etc etc
     */
    @Bean
    ItemReader<UserDTO> restStudentReader(Environment environment, RestTemplate restTemplate) {
    	
        return new RESTUserReader(
            //environment.getRequiredProperty("get.users.list.url"), 	// using simple REST API
        	environment.getRequiredProperty("get.user.for.id.url"),		// using HTTP Headers 
            restTemplate
        );
    }
	
	// Returns a instance of RestTemplate
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
