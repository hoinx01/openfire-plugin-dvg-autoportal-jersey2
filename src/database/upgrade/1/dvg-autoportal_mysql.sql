CREATE TABLE ofdvgapusers (
  id            int             NOT NULL AUTO_INCREMENT,
  ofUsername    VARCHAR(255)    NOT NULL,
  dvgApApplicationId VARCHAR(255)    NOT NULL,
  dvgApUserRegistered BIT    NOT NULL,
  dvgApUserIdentifier VARCHAR(255) NOT NULL,
  dvgApUserName          VARCHAR(255)    NULL,
  dvgApUserEmail         VARCHAR(255)       NULL,
  dvgApUserPhoneNumber VARCHAR(255)  NULL,
  createdAt          DATETIME        NOT NULL,
  modifiedAt          DATETIME           NOT NULL,
  PRIMARY KEY (id),
  INDEX ofdvgapusers_username (ofUsername)
);

CREATE TABLE ofdvgapapplications(
  id            int             NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  createdAt datetime not null ,
  modifiedAt datetime not null,
  PRIMARY KEY (id)
);

CREATE TABLE ofdvgaptokens (
  id            BIGINT             NOT NULL AUTO_INCREMENT,
  displayedContent    VARCHAR(255)    NOT NULL,
  dvgApApplicationId int not null ,
  ownerType int not null ,
  ownerId varchar(255),
  createdAt          DATETIME        NOT NULL,
  expiredAt          DATETIME           NOT NULL,
  PRIMARY KEY (id),
  INDEX ofdvgaptokens_displayedContent (displayedContent)
);