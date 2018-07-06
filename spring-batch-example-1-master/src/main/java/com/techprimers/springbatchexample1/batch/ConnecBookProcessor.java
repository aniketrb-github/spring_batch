package com.techprimers.springbatchexample1.batch;

import com.techprimers.springbatchexample1.dto.ConnectBooksDTO;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ConnecBookProcessor implements ItemProcessor<ConnectBooksDTO, ConnectBooksDTO> {

    private ConnectBooksDTO book = new ConnectBooksDTO();

    @Override
    public ConnectBooksDTO process(ConnectBooksDTO user) throws Exception {
       
        return book;
    }
}
