insert into User2 (id,full_name,password,role,username) values(1,'alain','1234','USER','al@mail.fr');
insert into User2 (id,full_name,password,role,username) values(2,'jerome','1234','USER','jl@mail.fr');

insert into Panier (id,user_id) values(1,1);
insert into Panier (id,user_id) values(2,2);

insert into Produit (id,title,image_url,annee_sortie,genre,description,prix,auteur) values(1,'Thriller','https://upload.wikimedia.org/wikipedia/en/5/55/Michael_Jackson_-_Thriller.png',TO_DATE('30-11-1982','DD-MM-YYYY'),'funk-pop','6 eme album de Mickael Jackson, coproduit par Quincy Jones chez Epic Records, à la suite du succès commercial et critique de l album Off the Wall (1979).',12.50,'Mickael Jackson');

insert into Produit (id,title,image_url,annee_sortie,genre,description,prix,auteur) values(2,'Johnny Cash with His Hot and Blue Guitar','https://upload.wikimedia.org/wikipedia/en/d/d6/JohnnyCashWithHisHotAndBlueGuitar.jpg',TO_DATE('11-10-1957','DD-MM-YYYY'),'rock-blues','premier album de Johnny Cash, comprenant 4 titres et réédité en 2002',8,'Johnny Cash');

insert into Produit_Commande (id,produit_id,panier_id,quantite) values(1,1,1,2);
insert into Produit_Commande (id,produit_id,panier_id,quantite) values(2,2,1,1);
insert into Produit_Commande (id,produit_id,panier_id,quantite) values(3,1,2,4);
insert into Produit_Commande (id,produit_id,panier_id,quantite) values(4,2,2,3);