
CREATE Table `user`(
id varchar(40),
username varchar(100),
password varchar(100),
mail varchar(100),
tokens integer,
bet longtext,
profil varchar(10),
primary key(id)
);

CREATE Table `match`(
id varchar(40),
title varchar(200),
date_creation varchar(100),
play_date varchar(100),
end_date varchar(100),
teams longtext,
bets longtext,
primary key(id)
);

CREATE Table bet(
id varchar(40),
user_id varchar(40),
cote integer,
value integer,
pool_id varchar(40),
primary key(id)
);

CREATE Table pool(
id varchar(40),
title varchar(100),
cote integer(10),
bets longtext,
`result` varchar(30),
state varchar(10),
primary key(id)
);

