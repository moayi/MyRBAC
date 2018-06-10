package com.sx.entity;

import lombok.*;

import java.io.Serializable;

/**
 * Created by Liuqibo on 2017/5/10.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User  implements Serializable{
    private String Id;
    private String userName;
    private String passWord;
    private String email;
    private String zcsj;
    private String xgsj;
}
