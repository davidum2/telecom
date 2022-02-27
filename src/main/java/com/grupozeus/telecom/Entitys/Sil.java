package com.grupozeus.telecom.Entitys;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


import lombok.Data;

@Data
@Entity
@Table(name="sil")
public class Sil {
  
@Id
@GeneratedValue(generator = "uuid")
@GenericGenerator(name="uuid", strategy = "uuid2")
@Column(name="idsil")
private String idsil;

private String descripcion;

private double valor;



}
