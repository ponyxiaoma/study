package com.mjq.es.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by majingqiang on 2018/11/10.
 */
@Document(indexName = "study", type = "user" )
@Data
public class User implements Serializable {

    @Id
    private String id;

    private String name;

    private Date birthday;

}
