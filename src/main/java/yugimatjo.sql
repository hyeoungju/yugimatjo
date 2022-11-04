CREATE TABLE User (
	uId			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	userName 	VARCHAR(20)		NOT NULL,
	userId		VARCHAR(20)		NOT NULL,
	passwd		VARCHAR(20)		NOT NULL,
	nickName	VARCHAR(20)		NOT NULL,
	grade		VARCHAR(20)		NOT NULL		DEFAULT '메추리알',
	position 	CHAR(1)			NOT NULL		DEFAULT 'U'
) AUTO_INCREMENT = 1001;

INSERT INTO User (userName, userId, passwd, nickName)
VALUES ('남형주','gudwn88','aa111','hyeoungju');

INSERT INTO User (userName, userId, passwd, nickName, position)
VALUES ('관리자','manager','qwer123','manager', 'M');

CREATE TABLE Restaurant (
   rId                 BIGINT         PRIMARY KEY AUTO_INCREMENT,
   resName             VARCHAR(50)    NOT NULL,
   resScore            DOUBLE         NOT NULL,
   foodType            VARCHAR(30)    NOT NULL,
   foodPrice           INT            NOT NULL,
   resCapacity         INT            NOT NULL
) AUTO_INCREMENT = 2001;

SELECT * FROM User;

SELECT * FROM Restaurant;

SELECT * FROM Account;

SELECT * FROM Review;

SELECT * FROM Location;

SELECT * FROM Ambiance;

UPDATE Account SET point=point+15 WHERE userId=1020;

UPDATE User A INNER JOIN Account B ON
A.uid=B.userId
SET A.grade = 
CASE 
WHEN B.point >= 300 THEN '계란'
WHEN B.point >=700 THEN '타조알'
WHEN B.point >=1200 THEN '독수리알'
END;


CREATE TABLE Account (
	pId				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	userId 			BIGINT			NOT NULL,
	point			INT				NOT NULL		DEFAULT 0,
	
	CONSTRAINT Account_userId_FK FOREIGN KEY (userId) REFERENCES User(uId)
) AUTO_INCREMENT = 3001;

DELETE FROM User WHERE uId=1019;

CREATE TABLE Review (
	reviewId		BIGINT			PRIMARY KEY AUTO_INCREMENT,
	userId 			BIGINT			NOT NULL,
	resId			BIGINT			NOT NULL,
	reviewText		MEDIUMTEXT		NOT NULL,
	regDate			TIMESTAMP		NOT NULL 		DEFAULT CURRENT_TIMESTAMP,
	recommandScore	INT				NOT NULL		DEFAULT 0,
	
	CONSTRAINT Review_userId_FK FOREIGN KEY (userId) REFERENCES User(uId),
	CONSTRAINT Review_resId_FK FOREIGN KEY (resId) REFERENCES Restaurant(rId)
) AUTO_INCREMENT = 4001;



CREATE TABLE Location (
	lId				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	regionName 		VARCHAR(50)		NOT NULL,
	resId			BIGINT			NOT NULL,
	
	CONSTRAINT Location_resId_FK FOREIGN KEY (resId) REFERENCES Restaurant(rId)
) AUTO_INCREMENT = 5001;



CREATE TABLE Ambiance (
	aId				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	resId 			BIGINT			NOT NULL,
	comfort			INT				NOT NULL		DEFAULT 0,
	luxury			INT				NOT NULL		DEFAULT 0,
	cost			INT				NOT NULL		DEFAULT 0,
	dating			INT				NOT NULL		DEFAULT 0,
	family			INT				NOT NULL		DEFAULT 0,
	comfortScore	INT				NOT NULL		DEFAULT 0,
	luxuryScore		INT				NOT NULL		DEFAULT 0,
	costScore		INT				NOT NULL		DEFAULT 0,
	datingScore		INT				NOT NULL		DEFAULT 0,
	familyScore		INT				NOT NULL		DEFAULT 0,
	
	CONSTRAINT Ambiance_resId_FK FOREIGN KEY (resId) REFERENCES Restaurant(rId)
) AUTO_INCREMENT = 6001;



DROP TABLE Restaurant;

DELETE FROM Restaurant WHERE rId=2006;
SELECT r.*, lo.regionName, ab.comfort / ab.comfortScore as '편안한', ab.luxury / ab.luxuryScore as '럭셔리한', 
ab.cost / ab.costScore as '가성비', ab.dating / ab.datingScore as '데이트하기좋은', ab.family / ab.familyScore as '가족' FROM Restaurant r 
INNER JOIN Ambiance ab ON r.rId = ab.resId INNER JOIN Location 
lo ON r.rId = lo.resId WHERE lo.regionName='대구 중구' AND r.foodType='일식' 
AND r.foodPrice <= 60000 AND r.resCapacity <= 2;
