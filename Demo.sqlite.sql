BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Choices" (
	"choice_id"	INTEGER,
	"question_id"	INTEGER,
	"choice"	TEXT,
	PRIMARY KEY("choice_id")
);
CREATE TABLE IF NOT EXISTS "Category" (
	"category_id"	INTEGER,
	"type"	TEXT,
	PRIMARY KEY("category_id")
);
CREATE TABLE IF NOT EXISTS "Question" (
	"question_id"	INTEGER,
	"question_text"	TEXT,
	"category_id"	INTEGER,
	PRIMARY KEY("question_id")
);
CREATE TABLE IF NOT EXISTS "Answer" (
	"Answer_id"	INTEGER,
	"Question_id"	INTEGER,
	"Answer"	INTEGER,
	PRIMARY KEY("Answer_id")
);
INSERT INTO "Choices" VALUES (1,1,'a) API');
INSERT INTO "Choices" VALUES (2,1,'b) JLSs');
INSERT INTO "Choices" VALUES (3,1,'c) JDKs');
INSERT INTO "Choices" VALUES (4,1,'d) IDEs');
INSERT INTO "Choices" VALUES (5,2,'a) a++');
INSERT INTO "Choices" VALUES (6,2,'b)  It doesn''t matter');
INSERT INTO "Choices" VALUES (7,2,'c) --b');
INSERT INTO "Choices" VALUES (8,2,'d)  Neither');
INSERT INTO "Choices" VALUES (9,3,'a) double');
INSERT INTO "Choices" VALUES (10,3,'b)  string');
INSERT INTO "Choices" VALUES (11,3,'c) char');
INSERT INTO "Choices" VALUES (12,3,'d)  int');
INSERT INTO "Choices" VALUES (13,4,'a) string');
INSERT INTO "Choices" VALUES (14,4,'b) int');
INSERT INTO "Choices" VALUES (15,4,'c) long');
INSERT INTO "Choices" VALUES (16,4,'d) void');
INSERT INTO "Choices" VALUES (17,5,'a) semicolon (;)');
INSERT INTO "Choices" VALUES (18,5,'b) comma (,)');
INSERT INTO "Choices" VALUES (19,5,'c) period (.)');
INSERT INTO "Choices" VALUES (20,5,'d) asterisk (*)');
INSERT INTO "Category" VALUES (101,NULL);
INSERT INTO "Category" VALUES (102,'multiple choice');
INSERT INTO "Category" VALUES (103,'true/false');
INSERT INTO "Category" VALUES (104,'short answer');
INSERT INTO "Question" VALUES (1,'Net Beans and Eclipse are examples of:',102);
INSERT INTO "Question" VALUES (2,'If a++ and --b are used at the same level in an expression, which is performed first?',102);
INSERT INTO "Question" VALUES (3,'What type of return does the length() method return?',102);
INSERT INTO "Question" VALUES (4,'Which of the following types would be used for a method that has no return value?',102);
INSERT INTO "Question" VALUES (5,'Every statement in Java ends with ________.',102);
INSERT INTO "Answer" VALUES (1,1,'d');
INSERT INTO "Answer" VALUES (2,2,'a');
INSERT INTO "Answer" VALUES (3,2,'d');
INSERT INTO "Answer" VALUES (4,4,'d');
INSERT INTO "Answer" VALUES (5,5,'a');
COMMIT;
