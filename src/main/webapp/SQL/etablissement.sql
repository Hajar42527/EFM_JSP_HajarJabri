create database if not exists jspEtablissement;
use jspEtablissement;
create table
etablissement(
code_etab int auto_increment primary key,
 Nom_Etab varchar(250),
 Adresse_etab varchar(250), 
 Tel_etab varchar(250));
 
 insert into etablissement(code_etab, Nom_Etab, Adresse_etab, Tel_etab) values(null,"ISMO TETOUAN","Martil","0690536278");
 insert into etablissement(code_etab, Nom_Etab, Adresse_etab, Tel_etab) values(null,"ROUTE DE SABTA","TETOUAN","0690536278");
 insert into etablissement(code_etab, Nom_Etab, Adresse_etab, Tel_etab) values(null,"ISMO TETOUAN","Martil","0690536278");
 
 select * from etablissement;