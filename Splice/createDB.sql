CREATE DATABASE Game611;

CREATE TABLE card(
	card_id INT(4) PRIMARY KEY,
	card_flavor VARCHAR(255) NOT NULL,
	card_name VARCHAR(255) NOT NULL,
	img_back VARCHAR(255) NOT NULL,
	img_border VARCHAR(255) NOT NULL,
	img_front VARCHAR(255) NOT NULL
);

CREATE TABLE creature(
	card_id INT(4) PRIMARY KEY,
	vit INT(2) NOT NULL,
	pow INT(2) NOT NULL,
	def INT(2) NOT NULL,
	spd INT(2) NOT NULL,
	itl INT(2) NOT NULL,
	favored_stat INT(2) NOT NULL,
	dump_stat INT(2) NOT NULL,
	temperment INT(2) NOT NULL,
	aggr_rating INT(2) NOT NULL
);

CREATE TABLE sorcerer(
	card_id INT(4) PRIMARY KEY,
	vit INT(2) NOT NULL,
	pow INT(2) NOT NULL,
	def INT(2) NOT NULL,
	spd INT(2) NOT NULL,
	itl INT(2) NOT NULL	
);

CREATE TABLE spell(
	card_id INT(4) PRIMARY KEY,
	casting_cost INT(2),
	casting_spd BOOLEAN
);

CREATE TABLE user_login(
	username VARCHAR(255),
	passwd VARCHAR(255),
	token VARCHAR(255)
);

ALTER TABLE creature
ADD CONSTRAINT fk_creature_card
FOREIGN KEY (card_id)
REFERENCES card(card_id);

ALTER TABLE sorcerer
ADD CONSTRAINT fk_sorcerer_card
FOREIGN KEY (card_id)
REFERENCES card(card_id);

ALTER TABLE spell
ADD CONSTRAINT fk_spell_card
FOREIGN KEY (card_id)
REFERENCES card(card_id);