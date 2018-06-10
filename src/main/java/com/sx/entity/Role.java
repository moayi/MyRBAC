package com.sx.entity;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Role implements Serializable {
	private String id;
	private String name;
}
