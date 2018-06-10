package com.sx.entity;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Permission implements Serializable {
	private String id;
	private String name;
	private String url;
	private String pid;
	private boolean open;
	private boolean checked = false;
	private String icon;
	private List<Permission> children = new ArrayList<Permission>();
}
