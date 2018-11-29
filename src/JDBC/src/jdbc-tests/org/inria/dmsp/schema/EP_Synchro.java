package org.inria.dmsp.schema;
//  ////////////////////////////////////////////////// 
//  // CODE AFTER THAT IS GENERATED BY QEPGenerator // 
//  ////////////////////////////////////////////////// 

//  This is the set of SQL queries used to generate EP_Synchro.java 
//  Note that : 
//    - EP generation fails (bug...) when altogether, must be generated by query type  
//    - EP generation for queries marked by x is buggy and must be corrected by hand 

//  NB: to be able to quickly build the java file, a header is placed at the  
//  beginning of the file and should be removed from the output. 
//  --> Replace "//JAVA " by "" in the output. 

//  Bugs: 
//  buggy plans are tagged with "TODO"  
//  --> those plans must be corrected manually 

public class EP_Synchro {
//   PLANS: 
//     EP_INFO_SELECT_BY_ID 
//     EP_USER_SELECT_BY_ID 
//     EP_EPISODE_SELECT_BY_ID 
//     EP_FORMULAIRE_SELECT_BY_ID 
//     EP_ROLE_SELECT_BY_ID 
//     EP_EVENT_SELECT_BY_ID 
//     EP_COMMENT_SELECT_BY_ID 
//     EP_HABILITATION_SELECT_BY_ID 
//     EP_PATIENT_SELECT_BY_ID 
//     EP_COMMENT_SELECT_BY_ID 
//     EP_INFO_SELECT_ON_TSSPT 
//     EP_COMMENT_SELECT_ON_TSSPT 
//     EP_INFO_UPDATE 
//     EP_COMMENT_UPDATE 
//     EP_EPISODE_UPDATE 
//     EP_EPISODE_INSERT 
//     EP_FORMULAIRE_INSERT 
//     EP_USER_INSERT 
//     EP_PATIENT_SELECT_ON_TSSPT 
//     EP_EPISODE_SELECT_ON_TSSPT 
//     EP_HABILITATION_SELECT_ON_TSSPT 
//     EP_EVENT_INSERT 
//     EP_INFO_INSERT 
//     EP_COMMENT_INSERT 
//     EP_ROLE_INSERT 
//     EP_HABILITATION_INSERT 
//     EP_HABILITATION_DELETE 
//     EP_INFO_DELETE 
//     EP_COMMENT_DELETE 
//     EP_PATIENT_INSERT_AUTRE_USER 
//     EP_PATIENT_INSERT_AUTRE_ROLE 
//     EP_PATIENT_INSERT_USER_USER 
//     EP_PATIENT_INSERT_USER_ROLE 
//     EP_PATIENT_INSERT_FORMULAIRE_USER 
//     EP_PATIENT_INSERT_FORMULAIRE_ROLE 
//     EP_PATIENT_INSERT_EPISODE_USER 
//     EP_PATIENT_INSERT_EPISODE_ROLE 
//     EP_ROLE_SELECT_ON_TSSPT 


public static String EP_INFO_SELECT_BY_ID =
/* SQL : 	SELECT * FROM Info WHERE IdGlobal = ?; */
"/*EP \u0001 " + 
"2 1 1 -1 6 ?1 # " + /* CI_LOOKUP ref_tab:Info(4) key_col_id:36 ka_id:6	 key:?1(R0) -->R1 */
"1 0 0 1 r1 11 4 1 37 38 39 40 41 42 43 44 45 46 92 # " + /* TABLE_LOOKUP pos:R1, 11 cols, table Info(4), is_table: 1	-->R2 - R12 */
"\u0000 12 1 0 IdGlobal 1 2 Author 1 3 TSSPT 1 4 TSSanteos 1 5 IdEvent 1 6 IdComment 0 7 ValChar 1 8 ValNum 2 9 ValDate 1 10 Position 1 11 Filtre 1 12 IdConcept # " + /* META_RESULT, 12 cols, type(0-char 1-num 2-date) [out_result name] */
"\u0000*/";


public static String EP_USER_SELECT_BY_ID =
/* SQL : 	SELECT * FROM UserDMSP WHERE IdGlobal = ?; */
"/*EP \u0001 " + 
"2 1 1 -1 4 ?1 # " + /* CI_LOOKUP ref_tab:UserDMSP(2) key_col_id:10 ka_id:4	 key:?1(R0) -->R1 */
"1 0 0 1 r1 18 2 1 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 93 # " + /* TABLE_LOOKUP pos:R1, 18 cols, table UserDMSP(2), is_table: 1	-->R2 - R19 */
"\u0000 19 1 0 IdGlobal 1 2 Author 1 3 TSSPT 1 4 TSSanteos 0 5 Nom 1 6 Type 0 7 Responsable 0 8 Identifiant 1 9 Civilite 0 10 Prenom 0 11 Adresse 0 12 Ville 0 13 CodePost 0 14 Tel 0 15 Mobile 0 16 Courriel 1 17 InfoLegale 0 18 Certificate 1 19 IdRole # " + /* META_RESULT, 19 cols, type(0-char 1-num 2-date) [out_result name] */
"\u0000*/";


public static String EP_EPISODE_SELECT_BY_ID  =
/* SQL : 	SELECT * FROM Episode WHERE IdGlobal = ?; */
"/*EP \u0001 " + 
"2 1 1 -1 0 ?1 # " + /* CI_LOOKUP ref_tab:Episode(0) key_col_id:0 ka_id:0	 key:?1(R0) -->R1 */
"1 0 0 1 r1 4 0 1 1 2 3 4 # " + /* TABLE_LOOKUP pos:R1, 4 cols, table Episode(0), is_table: 1	-->R2 - R5 */
"\u0000 5 1 0 IdGlobal 1 2 Author 1 3 TSSPT 1 4 TSSanteos 0 5 Nom # " + /* META_RESULT, 5 cols, type(0-char 1-num 2-date) [out_result name] */
"\u0000*/";


public static String EP_FORMULAIRE_SELECT_BY_ID =
/* SQL : 	SELECT * FROM Formulaire WHERE IdGlobal = ?; */
"/*EP \u0001 " + 
"2 1 1 -1 1 ?1 # " + /* CI_LOOKUP ref_tab:Formulaire(1) key_col_id:5 ka_id:1	 key:?1(R0) -->R1 */
"1 0 0 1 r1 5 1 1 6 7 8 9 94 # " + /* TABLE_LOOKUP pos:R1, 5 cols, table Formulaire(1), is_table: 1	-->R2 - R6 */
"\u0000 6 1 0 IdGlobal 1 2 Author 1 3 TSSPT 1 4 TSSanteos 0 5 Nom 1 6 Filtre # " + /* META_RESULT, 6 cols, type(0-char 1-num 2-date) [out_result name] */
"\u0000*/";


public static String EP_ROLE_SELECT_BY_ID =
/* SQL : 	SELECT * FROM Role WHERE IdGlobal = ?; */
"/*EP \u0001 " + 
"2 1 1 -1 8 ?1 # " + /* CI_LOOKUP ref_tab:Role(6) key_col_id:52 ka_id:8	 key:?1(R0) -->R1 */
"1 0 0 1 r1 4 6 1 53 54 55 56 # " + /* TABLE_LOOKUP pos:R1, 4 cols, table Role(6), is_table: 1	-->R2 - R5 */
"\u0000 5 1 0 IdGlobal 1 2 Author 1 3 TSSPT 1 4 TSSanteos 0 5 Nom # " + /* META_RESULT, 5 cols, type(0-char 1-num 2-date) [out_result name] */
"\u0000*/";


public static String EP_EVENT_SELECT_BY_ID =
/* SQL : 	SELECT * FROM Event WHERE IdGlobal = ?; */
"/*EP \u0001 " + 
"2 1 1 -1 5 ?1 # " + /* CI_LOOKUP ref_tab:Event(3) key_col_id:28 ka_id:5	 key:?1(R0) -->R1 */
"1 0 0 1 r1 9 3 1 29 30 31 32 33 34 35 95 96 # " + /* TABLE_LOOKUP pos:R1, 9 cols, table Event(3), is_table: 1	-->R2 - R10 */
"\u0000 10 1 0 IdGlobal 1 2 Author 1 3 TSSPT 1 4 TSSanteos 1 5 IdForm 1 6 IdUser 1 7 IdEpisode 2 8 DateEvent 2 9 DateFin 1 10 Filtre # " + /* META_RESULT, 10 cols, type(0-char 1-num 2-date) [out_result name] */
"\u0000*/";


public static String EP_HABILITATION_SELECT_BY_ID =
/* SQL : 	SELECT * FROM Habilitation WHERE IdGlobal = ?; */
"/*EP \u0001 " + 
"2 1 1 -1 9 ?1 # " + /* CI_LOOKUP ref_tab:Habilitation(8) key_col_id:57 ka_id:9	 key:?1(R0) -->R1 */
"1 0 0 1 r1 5 8 1 58 59 60 62 63 # " + /* TABLE_LOOKUP pos:R1, 5 cols, table Habilitation(8), is_table: 1	-->R2 - R6 */
"\u0000 6 1 0 IdGlobal 1 2 Author 1 3 TSSPT 1 4 TSSanteos 1 5 IdRole 1 6 IdUser # " + /* META_RESULT, 6 cols, type(0-char 1-num 2-date) [out_result name] */
"\u0000*/";


public static String EP_PATIENT_SELECT_BY_ID =
/* SQL : 	SELECT * FROM MatricePatient WHERE IdGlobal = ?; */
"/*EP \u0001 " + 
"0 2 2 10 # " + /* SCAN, Table MatricePatient (10) -->R0 */
"1 1 1 2 r0 9 10 1 71 72 73 74 75 76 77 78 79 # " + /* TABLE_LOOKUP pos:R0, 9 cols, table MatricePatient(10), is_table: 1	-->R1 - R9 */
"4 0 0 1 71 0 ?1 r1 # " + /* SELECT, att: IdGlobal(71), comparator: 0, parameter: ?1 (R10), from pos: R1*/
"\u0000 9 1 1 IdGlobal 1 2 Author 1 3 TSSPT 1 4 TSSanteos 1 5 IdCategorie 1 6 TypeCategorie 1 7 IdActeur 1 8 TypeActeur 1 9 Autorisations # " + /* META_RESULT, 9 cols, type(0-char 1-num 2-date) [out_result name] */
"\u0000*/";


public static String EP_COMMENT_SELECT_BY_ID =
/* SQL : 	SELECT * FROM Comment WHERE IdGlobal = ?; */
"/*EP \u0001 " + 
"2 1 1 -1 7 ?1 # " + /* CI_LOOKUP ref_tab:Comment(5) key_col_id:47 ka_id:7	 key:?1(R0) -->R1 */
"1 0 0 1 r1 4 5 1 48 49 50 51 # " + /* TABLE_LOOKUP pos:R1, 4 cols, table Comment(5), is_table: 1	-->R2 - R5 */
"\u0000 5 1 0 IdGlobal 1 2 Author 1 3 TSSPT 1 4 TSSanteos 0 5 ValComment # " + /* META_RESULT, 5 cols, type(0-char 1-num 2-date) [out_result name] */
"\u0000*/";


public static final String EP_INFO_SELECT_ON_TSSPT =
/* SQL : 	SELECT i.IdGlobal, i.Author, i.TSSPT, i.TSSanteos, i.IdEvent, i.IdComment, i.ValChar, i.ValNum, i.ValDate, i.Position, i.Filtre, i.IdConcept FROM info i, event e WHERE i.IdEvent=e.IdGlobal AND e.TSSPT > 0 AND i.TSSPT > ? */
"/*EP \u0001 " + 
"0 5 5 4 # " + /* SCAN, Table Info (4) -->R0 */
"1 4 4 5 r0 12 4 1 36 37 38 39 40 41 42 43 44 45 46 92 # " + /* TABLE_LOOKUP pos:R0, 12 cols, table Info(4), is_table: 1	-->R1 - R12 */
"4 3 3 4 38 1 ?1 r3 # " + /* SELECT, att: TSSPT(38), comparator: 1, parameter: ?1 (R13), from pos: R3*/
"1 2 2 3 r0 1 1 0 3 # " + /* TABLE_LOOKUP pos:R0, 1 cols, skt SktInfo(1), is_table: 0  -->R14 - R14 */
"1 1 1 2 r14 1 3 1 30 # " + /* TABLE_LOOKUP pos:R14, 1 cols, table Event(3), is_table: 1	-->R15 - R15 */
"4 0 0 1 30 1 v10 r15 # " + /* SELECT, att: TSSPT(30), comparator: 1, parameter: v10 (R16), from pos: R15*/
"\u0000 12 1 1 IdGlobal 1 2 Author 1 3 TSSPT 1 4 TSSanteos 1 5 IdEvent 1 6 IdComment 0 7 ValChar 1 8 ValNum 2 9 ValDate 1 10 Position 1 11 Filtre 1 12 IdConcept # " + /* META_RESULT, 12 cols, type(0-char 1-num 2-date) [out_result name] */
"\u0000*/";


public static final String EP_COMMENT_SELECT_ON_TSSPT =
/* SQL : 	SELECT c.IdGlobal, c.Author, c.TSSPT, c.TSSanteos, c.ValComment FROM Comment c, Info i, Event e WHERE i.IdEvent=e.IdGlobal AND i.IdComment=c.IdGlobal AND e.TSSPT > 0 AND c.TSSPT > ? */
"/*EP \u0001 " + 
"0 5 5 4 # " + /* SCAN, Table Info (4) -->R0 */
"1 4 4 5 r0 2 1 0 4 3 # " + /* TABLE_LOOKUP pos:R0, 2 cols, skt SktInfo(1), is_table: 0  -->R1 - R2 */
"1 3 3 4 r2 1 3 1 30 # " + /* TABLE_LOOKUP pos:R2, 1 cols, table Event(3), is_table: 1	-->R3 - R3 */
"4 2 2 3 30 1 v10 r3 # " + /* SELECT, att: TSSPT(30), comparator: 1, parameter: v10 (R4), from pos: R3*/
"1 1 1 2 r1 5 5 1 47 48 49 50 51 # " + /* TABLE_LOOKUP pos:R1, 5 cols, table Comment(5), is_table: 1	-->R5 - R9 */
"4 0 0 1 49 1 ?1 r7 # " + /* SELECT, att: TSSPT(49), comparator: 1, parameter: ?1 (R10), from pos: R7*/
"\u0000 5 1 5 IdGlobal 1 6 Author 1 7 TSSPT 1 8 TSSanteos 0 9 ValComment # " + /* META_RESULT, 5 cols, type(0-char 1-num 2-date) [out_result name] */
"\u0000*/";


public static String EP_EVENT_UPDATE =
/* SQL : 	UPDATE Event SET Author = ?, TSSPT = ?, TSSANTEOS = ? ,  DateEvent = ?, DateFin = ?, Filtre = ? WHERE IdGlobal = ?; */
"/*EP \u0007 " + 
"0 3 3 3 # " + /* SCAN, Table Event (3) -->R0 */
"1 2 2 3 r0 4 3 1 32 33 34 28 # " + /* TABLE_LOOKUP pos:R0, 4 cols, table Event(3), is_table: 1	-->R1 - R4 */
"4 1 1 2 28 0 ?7 r4 # " + /* SELECT, att: IdGlobal(28), comparator: 0, parameter: ?7 (R5), from pos: R4*/
"a 0 0 1 10 3 r0 28 ?7 29 ?1 30 ?2 31 ?3 32 r1 33 r2 34 r3 35 ?4 95 ?5 96 ?6 # " + /* TABLE UPDATE, 10 cols, Table Event(3), tuple pos: r0 [col_id res_id] */
"\u0000*/";


public static String EP_INFO_UPDATE =
/* SQL : 	UPDATE Info SET Author = ?, TSSPT = ?, TSSanteos = ?, ValChar = ?, ValNum = ?, ValDate = ?, Position = ?, Filtre = ?, IdConcept = ? WHERE IdGlobal = ?; */
"/*EP \n " + 
"0 3 3 4 # " + /* SCAN, Table Info (4) -->R0 */
"1 2 2 3 r0 3 4 1 40 41 36 # " + /* TABLE_LOOKUP pos:R0, 3 cols, table Info(4), is_table: 1	-->R1 - R3 */
"4 1 1 2 36 0 ?10 r3 # " + /* SELECT, att: IdGlobal(36), comparator: 0, parameter: ?10 (R4), from pos: R3*/
"a 0 0 1 12 4 r0 36 ?10 37 ?1 38 ?2 39 ?3 40 r1 41 r2 42 ?4 43 ?5 44 ?6 45 ?7 46 ?8 92 ?9 # " + /* TABLE UPDATE, 12 cols, Table Info(4), tuple pos: r0 [col_id res_id] */
"\u0000*/";


public static String EP_COMMENT_UPDATE =
/* SQL : 	UPDATE Comment SET Author = ?, TSSPT = ?, TSSanteos = ?, ValComment = ? WHERE IdGlobal = ?; */
"/*EP \u0005 " + 
"0 3 3 5 # " + /* SCAN, Table Comment (5) -->R0 */
"1 2 2 3 r0 1 5 1 47 # " + /* TABLE_LOOKUP pos:R0, 1 cols, table Comment(5), is_table: 1	-->R1 - R1 */
"4 1 1 2 47 0 ?5 r1 # " + /* SELECT, att: IdGlobal(47), comparator: 0, parameter: ?5 (R2), from pos: R1*/
"a 0 0 1 5 5 r0 47 ?5 48 ?1 49 ?2 50 ?3 51 ?4 # " + /* TABLE UPDATE, 5 cols, Table Comment(5), tuple pos: r0 [col_id res_id] */
"\u0000*/";


public static String EP_USER_UPDATE =
/* SQL : 	UPDATE UserDMSP SET Author = ?, TSSPT = ?, TSSanteos = ?, Nom = ?, Type = ?, Responsable = ?, Identifiant = ?, Civilite = ?, Prenom = ?, Adresse = ?, Ville = ?, CodePost = ?, Tel = ?, Mobile = ?, Courriel = ?, InfoLegale = ?, Certificate = ?, IdRole = ? WHERE IdGlobal = ? */
"/*EP \u0013 " + 
"0 3 3 2 # " + /* SCAN, Table UserDMSP (2) -->R0 */
"1 2 2 3 r0 1 2 1 10 # " + /* TABLE_LOOKUP pos:R0, 1 cols, table UserDMSP(2), is_table: 1	-->R1 - R1 */
"4 1 1 2 10 0 ?19 r1 # " + /* SELECT, att: IdGlobal(10), comparator: 0, parameter: ?19 (R2), from pos: R1*/
"a 0 0 1 19 2 r0 10 ?19 11 ?1 12 ?2 13 ?3 14 ?4 15 ?5 16 ?6 17 ?7 18 ?8 19 ?9 20 ?10 21 ?11 22 ?12 23 ?13 24 ?14 25 ?15 26 ?16 27 ?17 93 ?18 # " + /* TABLE UPDATE, 19 cols, Table UserDMSP(2), tuple pos: r0 [col_id res_id] */
"\u0000*/";


public static String EP_EPISODE_UPDATE =
/* SQL : 	UPDATE Episode SET Author = ?, TSSPT = ?, TSSanteos = ?, Nom = ? WHERE IdGlobal = ?; */
"/*EP \u0005 " + 
"0 3 3 0 # " + /* SCAN, Table Episode (0) -->R0 */
"1 2 2 3 r0 1 0 1 0 # " + /* TABLE_LOOKUP pos:R0, 1 cols, table Episode(0), is_table: 1	-->R1 - R1 */
"4 1 1 2 0 0 ?5 r1 # " + /* SELECT, att: IdGlobal(0), comparator: 0, parameter: ?5 (R2), from pos: R1*/
"a 0 0 1 5 0 r0 0 ?5 1 ?1 2 ?2 3 ?3 4 ?4 # " + /* TABLE UPDATE, 5 cols, Table Episode(0), tuple pos: r0 [col_id res_id] */
"\u0000*/";


public static final String EP_FORMULAIRE_UPDATE =
/* SQL : 	UPDATE Formulaire SET Author = ?, TSSPT = ?, TSSanteos = ?, Nom = ?, Filtre = ? WHERE IdGlobal = ? */
"/*EP \u0006 " + 
"0 3 3 1 # " + /* SCAN, Table Formulaire (1) -->R0 */
"1 2 2 3 r0 1 1 1 5 # " + /* TABLE_LOOKUP pos:R0, 1 cols, table Formulaire(1), is_table: 1	-->R1 - R1 */
"4 1 1 2 5 0 ?6 r1 # " + /* SELECT, att: IdGlobal(5), comparator: 0, parameter: ?6 (R2), from pos: R1*/
"a 0 0 1 6 1 r0 5 ?6 6 ?1 7 ?2 8 ?3 9 ?4 94 ?5 # " + /* TABLE UPDATE, 6 cols, Table Formulaire(1), tuple pos: r0 [col_id res_id] */
"\u0000*/";


public static final String EP_ROLE_UPDATE =
/* SQL : 	UPDATE Role SET Author = ?, TSSPT = ?, TSSanteos = ?, Nom = ? WHERE IdGlobal = ? */
"/*EP \u0005 " + 
"0 3 3 6 # " + /* SCAN, Table Role (6) -->R0 */
"1 2 2 3 r0 1 6 1 52 # " + /* TABLE_LOOKUP pos:R0, 1 cols, table Role(6), is_table: 1	-->R1 - R1 */
"4 1 1 2 52 0 ?5 r1 # " + /* SELECT, att: IdGlobal(52), comparator: 0, parameter: ?5 (R2), from pos: R1*/
"a 0 0 1 5 6 r0 52 ?5 53 ?1 54 ?2 55 ?3 56 ?4 # " + /* TABLE UPDATE, 5 cols, Table Role(6), tuple pos: r0 [col_id res_id] */
"\u0000*/";


public static final String EP_EPISODE_INSERT =
/* SQL : 	INSERT INTO Episode (IdGlobal, Author, TSSPT, TSSanteos, Nom) VALUES (?, ?, ?, ?, ?); */
"/*EP \u0005 " + 
"6 1 1 -1 0 ?1 # " + /* CI_INSERT ref_tab:Episode(0), key_tab:Episode(0), col:IdGlobal(0), ka_id:0, key:?1(R0) */
"5 0 0 1 5 0 1 0 r0 1 ?2 2 ?3 3 ?4 4 ?5 # " + /* TABLE_INSERT 5 cols, table Episode(0), is_table: 1, [col_id value] */
"\u0000*/";


public static final String EP_FORMULAIRE_INSERT =
/* SQL : 	INSERT INTO Formulaire (IdGlobal, Author, TSSPT, TSSanteos, Nom, Filtre) VALUES (?, ?, ?, ?, ?, ?); */
"/*EP \u0006 " + 
"6 1 1 -1 1 ?1 # " + /* CI_INSERT ref_tab:Formulaire(1), key_tab:Formulaire(1), col:IdGlobal(5), ka_id:1, key:?1(R0) */
"5 0 0 1 6 1 1 5 r0 6 ?2 7 ?3 8 ?4 9 ?5 94 ?6 # " + /* TABLE_INSERT 6 cols, table Formulaire(1), is_table: 1, [col_id value] */
"\u0000*/";


public static final String EP_USER_INSERT =
/* SQL : 	INSERT INTO UserDMSP (IdGlobal, Author, TSSPT, TSSanteos, Nom, Type, Responsable, Identifiant, Civilite, Prenom, Adresse, Ville, CodePost, Tel, Mobile, Courriel, InfoLegale, Certificate, IdRole) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); */
"/*EP \u0013 " + 
"6 1 1 -1 4 ?1 # " + /* CI_INSERT ref_tab:UserDMSP(2), key_tab:UserDMSP(2), col:IdGlobal(10), ka_id:4, key:?1(R0) */
"5 0 0 1 19 2 1 10 r0 11 ?2 12 ?3 13 ?4 14 ?5 15 ?6 16 ?7 17 ?8 18 ?9 19 ?10 20 ?11 21 ?12 22 ?13 23 ?14 24 ?15 25 ?16 26 ?17 27 ?18 93 ?19 # " + /* TABLE_INSERT 19 cols, table UserDMSP(2), is_table: 1, [col_id value] */
"\u0000*/";


public static String EP_PATIENT_SELECT_ON_TSSPT =
/* SQL : 	SELECT * FROM MatricePatient WHERE TSSPT > ?; */
"/*EP \u0001 " + 
"0 2 2 10 # " + /* SCAN, Table MatricePatient (10) -->R0 */
"1 1 1 2 r0 9 10 1 71 72 73 74 75 76 77 78 79 # " + /* TABLE_LOOKUP pos:R0, 9 cols, table MatricePatient(10), is_table: 1	-->R1 - R9 */
"4 0 0 1 73 1 ?1 r3 # " + /* SELECT, att: TSSPT(73), comparator: 1, parameter: ?1 (R10), from pos: R3*/
"\u0000 9 1 1 IdGlobal 1 2 Author 1 3 TSSPT 1 4 TSSanteos 1 5 IdCategorie 1 6 TypeCategorie 1 7 IdActeur 1 8 TypeActeur 1 9 Autorisations # " + /* META_RESULT, 9 cols, type(0-char 1-num 2-date) [out_result name] */
"\u0000*/";


public static String EP_EPISODE_SELECT_ON_TSSPT =
/* SQL : 	SELECT * FROM Episode WHERE TSSPT > ?; */
"/*EP \u0001 " + 
"0 2 2 0 # " + /* SCAN, Table Episode (0) -->R0 */
"1 1 1 2 r0 5 0 1 0 1 2 3 4 # " + /* TABLE_LOOKUP pos:R0, 5 cols, table Episode(0), is_table: 1	-->R1 - R5 */
"4 0 0 1 2 1 ?1 r3 # " + /* SELECT, att: TSSPT(2), comparator: 1, parameter: ?1 (R6), from pos: R3*/
"\u0000 5 1 1 IdGlobal 1 2 Author 1 3 TSSPT 1 4 TSSanteos 0 5 Nom # " + /* META_RESULT, 5 cols, type(0-char 1-num 2-date) [out_result name] */
"\u0000*/";


public static String EP_HABILITATION_SELECT_ON_TSSPT =
/* SQL : 	SELECT * FROM Habilitation WHERE TSSPT > ?; */
"/*EP \u0001 " + 
"0 2 2 8 # " + /* SCAN, Table Habilitation (8) -->R0 */
"1 1 1 2 r0 6 8 1 57 58 59 60 62 63 # " + /* TABLE_LOOKUP pos:R0, 6 cols, table Habilitation(8), is_table: 1	-->R1 - R6 */
"4 0 0 1 59 1 ?1 r3 # " + /* SELECT, att: TSSPT(59), comparator: 1, parameter: ?1 (R7), from pos: R3*/
"\u0000 6 1 1 IdGlobal 1 2 Author 1 3 TSSPT 1 4 TSSanteos 1 5 IdRole 1 6 IdUser # " + /* META_RESULT, 6 cols, type(0-char 1-num 2-date) [out_result name] */
"\u0000*/";


public static final String EP_EVENT_INSERT =
/* SQL : 	INSERT INTO Event (IdGlobal, Author, TSSPT, TSSanteos, IdForm, IdUser, IdEpisode, DateEvent, DateFin, Filtre) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?); */
"/*EP \n " + 
"2 6 6 -1 1 ?5 # " + /* CI_LOOKUP ref_tab:Formulaire(1) key_col_id:5 ka_id:1	 key:?5(R0) -->R1 */
"2 7 7 -1 4 ?6 # " + /* CI_LOOKUP ref_tab:UserDMSP(2) key_col_id:10 ka_id:4	 key:?6(R2) -->R3 */
"7 5 5 6 7 # " + /* FLOW_X */
"2 8 8 -1 0 ?7 # " + /* CI_LOOKUP ref_tab:Episode(0) key_col_id:0 ka_id:0	 key:?7(R4) -->R5 */
"7 4 4 5 8 # " + /* FLOW_X */
"6 3 3 4 2 ?5 # " + /* CI_INSERT ref_tab:Event(3), key_tab:Formulaire(1), col:IdGlobal(5), ka_id:2, key:?5(R6) */
"6 2 2 3 5 ?1 # " + /* CI_INSERT ref_tab:Event(3), key_tab:Event(3), col:IdGlobal(28), ka_id:5, key:?1(R7) */
"5 1 1 2 3 0 0 0 r1 1 r3 2 r5 # " + /* TABLE_INSERT 3 cols, skt SktEvent(0), is_table: 0, [col_id value] */
"5 0 0 1 10 3 1 28 r7 29 ?2 30 ?3 31 ?4 32 ?5 33 ?6 34 ?7 35 ?8 95 ?9 96 ?10 # " + /* TABLE_INSERT 10 cols, table Event(3), is_table: 1, [col_id value] */
"\u0000*/";


public static final String EP_INFO_INSERT =
/* SQL : 	INSERT INTO Info (IdGlobal, Author, TSSPT, TSSanteos, IdEvent, IdComment, ValChar, ValNum, ValDate, Position, Filtre, IdConcept) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); */
"/*EP \u000C " + 
"2 7 7 -1 5 ?5 # " + /* CI_LOOKUP ref_tab:Event(3) key_col_id:28 ka_id:5	 key:?5(R0) -->R1 */
"1 6 6 7 r1 3 0 0 0 1 2 # " + /* TABLE_LOOKUP pos:R1, 3 cols, skt SktEvent(0), is_table: 0  -->R2 - R4 */
"1 5 5 6 r2 1 1 1 5 # " + /* TABLE_LOOKUP pos:R2, 1 cols, table Formulaire(1), is_table: 1	-->R5 - R5 */
"2 8 8 -1 7 ?6 # " + /* CI_LOOKUP ref_tab:Comment(5) key_col_id:47 ka_id:7	 key:?6(R6) -->R7 */
"7 4 4 5 8 # " + /* FLOW_X */
"6 3 3 4 3 r5 # " + /* CI_INSERT ref_tab:Info(4), key_tab:Formulaire(1), col:IdGlobal(5), ka_id:3, key:R5 */
"6 2 2 3 6 ?1 # " + /* CI_INSERT ref_tab:Info(4), key_tab:Info(4), col:IdGlobal(36), ka_id:6, key:?1(R8) */
"5 1 1 2 5 1 0 0 r2 1 r3 2 r4 3 r1 4 r7 # " + /* TABLE_INSERT 5 cols, skt SktInfo(1), is_table: 0, [col_id value] */
"5 0 0 1 12 4 1 36 r8 37 ?2 38 ?3 39 ?4 40 ?5 41 ?6 42 ?7 43 ?8 44 ?9 45 ?10 46 ?11 92 ?12 # " + /* TABLE_INSERT 12 cols, table Info(4), is_table: 1, [col_id value] */
"\u0000*/";


public static final String EP_COMMENT_INSERT =
/* SQL : 	INSERT INTO Comment (IdGlobal, Author, TSSPT, TSSanteos, ValComment) VALUES (?, ?, ?, ?, ?); */
"/*EP \u0005 " + 
"6 1 1 -1 7 ?1 # " + /* CI_INSERT ref_tab:Comment(5), key_tab:Comment(5), col:IdGlobal(47), ka_id:7, key:?1(R0) */
"5 0 0 1 5 5 1 47 r0 48 ?2 49 ?3 50 ?4 51 ?5 # " + /* TABLE_INSERT 5 cols, table Comment(5), is_table: 1, [col_id value] */
"\u0000*/";


public static final String EP_EVENT_SELECT_ON_TSSPT =
/* SQL : 	Select * from event where TSSPT > ? */
"/*EP \u0001 " + 
"0 2 2 3 # " + /* SCAN, Table Event (3) -->R0 */
"1 1 1 2 r0 10 3 1 28 29 30 31 32 33 34 35 95 96 # " + /* TABLE_LOOKUP pos:R0, 10 cols, table Event(3), is_table: 1	-->R1 - R10 */
"4 0 0 1 30 1 ?1 r3 # " + /* SELECT, att: TSSPT(30), comparator: 1, parameter: ?1 (R11), from pos: R3*/
"\u0000 10 1 1 IdGlobal 1 2 Author 1 3 TSSPT 1 4 TSSanteos 1 5 IdForm 1 6 IdUser 1 7 IdEpisode 2 8 DateEvent 2 9 DateFin 1 10 Filtre # " + /* META_RESULT, 10 cols, type(0-char 1-num 2-date) [out_result name] */
"\u0000*/";


public static final String EP_USER_SELECT_ON_TSSPT =
/* SQL : 	Select * from userdmsp where TSSPT > ? */
"/*EP \u0001 " + 
"0 2 2 2 # " + /* SCAN, Table UserDMSP (2) -->R0 */
"1 1 1 2 r0 19 2 1 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 93 # " + /* TABLE_LOOKUP pos:R0, 19 cols, table UserDMSP(2), is_table: 1	-->R1 - R19 */
"4 0 0 1 12 1 ?1 r3 # " + /* SELECT, att: TSSPT(12), comparator: 1, parameter: ?1 (R20), from pos: R3*/
"\u0000 19 1 1 IdGlobal 1 2 Author 1 3 TSSPT 1 4 TSSanteos 0 5 Nom 1 6 Type 0 7 Responsable 0 8 Identifiant 1 9 Civilite 0 10 Prenom 0 11 Adresse 0 12 Ville 0 13 CodePost 0 14 Tel 0 15 Mobile 0 16 Courriel 1 17 InfoLegale 0 18 Certificate 1 19 IdRole # " + /* META_RESULT, 19 cols, type(0-char 1-num 2-date) [out_result name] */
"\u0000*/";


public static final String EP_ROLE_INSERT =
/* SQL : 	INSERT INTO Role (IdGlobal, Author, TSSPT, TSSanteos, Nom) VALUES (?, ?, ?, ?, ?); */
"/*EP \u0005 " + 
"6 1 1 -1 8 ?1 # " + /* CI_INSERT ref_tab:Role(6), key_tab:Role(6), col:IdGlobal(52), ka_id:8, key:?1(R0) */
"5 0 0 1 5 6 1 52 r0 53 ?2 54 ?3 55 ?4 56 ?5 # " + /* TABLE_INSERT 5 cols, table Role(6), is_table: 1, [col_id value] */
"\u0000*/";


public static final String EP_HABILITATION_INSERT =
/* SQL : 	INSERT INTO Habilitation (IdGlobal, Author, TSSPT, TSSanteos, IdRole, IdUser) VALUES (?, ?, ?, ?, ?, ?); */
"/*EP \u0006 " + 
"2 4 4 -1 8 ?5 # " + /* CI_LOOKUP ref_tab:Role(6) key_col_id:52 ka_id:8	 key:?5(R0) -->R1 */
"2 5 5 -1 4 ?6 # " + /* CI_LOOKUP ref_tab:UserDMSP(2) key_col_id:10 ka_id:4	 key:?6(R2) -->R3 */
"7 3 3 4 5 # " + /* FLOW_X */
"6 2 2 3 9 ?1 # " + /* CI_INSERT ref_tab:Habilitation(8), key_tab:Habilitation(8), col:IdGlobal(57), ka_id:9, key:?1(R4) */
"5 1 1 2 2 2 0 0 r1 1 r3 # " + /* TABLE_INSERT 2 cols, skt SktHabili(2), is_table: 0, [col_id value] */
"5 0 0 1 6 8 1 57 r4 58 ?2 59 ?3 60 ?4 62 ?5 63 ?6 # " + /* TABLE_INSERT 6 cols, table Habilitation(8), is_table: 1, [col_id value] */
"\u0000*/";


public static final String EP_FORMULAIRE_SELECT_ON_TSSPT =
/* SQL : 	Select * from formulaire where TSSPT > ? */
"/*EP \u0001 " + 
"0 2 2 1 # " + /* SCAN, Table Formulaire (1) -->R0 */
"1 1 1 2 r0 6 1 1 5 6 7 8 9 94 # " + /* TABLE_LOOKUP pos:R0, 6 cols, table Formulaire(1), is_table: 1	-->R1 - R6 */
"4 0 0 1 7 1 ?1 r3 # " + /* SELECT, att: TSSPT(7), comparator: 1, parameter: ?1 (R7), from pos: R3*/
"\u0000 6 1 1 IdGlobal 1 2 Author 1 3 TSSPT 1 4 TSSanteos 0 5 Nom 1 6 Filtre # " + /* META_RESULT, 6 cols, type(0-char 1-num 2-date) [out_result name] */
"\u0000*/";


public static final String EP_HABILITATION_DELETE =
/* SQL : 	DELETE FROM Habilitation WHERE IdGlobal = ?; */
"/*EP \u0001 " + 
"0 4 4 8 # " + /* SCAN, Table Habilitation (8) -->R0 */
"1 3 3 4 r0 1 8 1 57 # " + /* TABLE_LOOKUP pos:R0, 1 cols, table Habilitation(8), is_table: 1	-->R1 - R1 */
"4 2 2 3 57 0 ?1 r1 # " + /* SELECT, att: IdGlobal(57), comparator: 0, parameter: ?1 (R2), from pos: R1*/
"5 1 1 2 3 12 1 85 v18 86 r0 87 v10 # " + /* TABLE_INSERT 3 cols, table LogDeleted(12), is_table: 1, [col_id value] -->R3 - R4*/
"9 0 0 1 8 r0 # " + /* TABLE DELETE, table Habilitation(8), tuple pos: R0 */
"\u0000*/";


public static final String EP_INFO_DELETE =
/* SQL : 	DELETE FROM Info WHERE IdGlobal = ?; */
"/*EP \u0001 " + 
"0 4 4 4 # " + /* SCAN, Table Info (4) -->R0 */
"1 3 3 4 r0 1 4 1 36 # " + /* TABLE_LOOKUP pos:R0, 1 cols, table Info(4), is_table: 1	-->R1 - R1 */
"4 2 2 3 36 0 ?1 r1 # " + /* SELECT, att: IdGlobal(36), comparator: 0, parameter: ?1 (R2), from pos: R1*/
"5 1 1 2 3 12 1 85 v14 86 r0 87 v10 # " + /* TABLE_INSERT 3 cols, table LogDeleted(12), is_table: 1, [col_id value] -->R3 - R4*/
"9 0 0 1 4 r0 # " + /* TABLE DELETE, table Info(4), tuple pos: R0 */
"\u0000*/";


public static final String EP_COMMENT_DELETE =
/* SQL : 	DELETE FROM Comment WHERE IdGlobal = ?; */
"/*EP \u0001 " + 
"0 4 4 5 # " + /* SCAN, Table Comment (5) -->R0 */
"1 3 3 4 r0 1 5 1 47 # " + /* TABLE_LOOKUP pos:R0, 1 cols, table Comment(5), is_table: 1	-->R1 - R1 */
"4 2 2 3 47 0 ?1 r1 # " + /* SELECT, att: IdGlobal(47), comparator: 0, parameter: ?1 (R2), from pos: R1*/
"5 1 1 2 3 12 1 85 v15 86 r0 87 v10 # " + /* TABLE_INSERT 3 cols, table LogDeleted(12), is_table: 1, [col_id value] -->R3 - R4*/
"9 0 0 1 5 r0 # " + /* TABLE DELETE, table Comment(5), tuple pos: R0 */
"\u0000*/";


public static final String EP_DELETED_SELECT_ON_TSSPT =
/* SQL : 	SELECT * from TupleDeleted where TSSPT > ? */
"/*EP \u0001 " + 
"0 2 2 11 # " + /* SCAN, Table TupleDeleted (11) -->R0 */
"1 1 1 2 r0 5 11 1 80 81 82 83 84 # " + /* TABLE_LOOKUP pos:R0, 5 cols, table TupleDeleted(11), is_table: 1	-->R1 - R5 */
"4 0 0 1 83 1 ?1 r4 # " + /* SELECT, att: TSSPT(83), comparator: 1, parameter: ?1 (R6), from pos: R4*/
"\u0000 5 1 1 IdGlobal 1 2 TabId 1 3 Author 1 4 TSSPT 1 5 TSSanteos # " + /* META_RESULT, 5 cols, type(0-char 1-num 2-date) [out_result name] */
"\u0000*/";


// manually created 
// there are multiple insert EPs, selection is done in tupleInsert below 
//---- Multiple INSERTS ----
// CATEGORIE AUTRE: 

public static String EP_PATIENT_INSERT_AUTRE_USER	=  // NEWSCHEMA OK // COMMENT OK // CHECK OK // TEST OK
  //Insert into matricepatient values (?,?,?,?,?,?,?,?,?)
  "/*EP \u0009 5 0 0 1 9 10 1 71 ?1 72 ?2 73 ?3 74 ?4 75 ?5 76 ?6 77 ?7 78 ?8 79 ?9 # " +
  // TABLE_INSERT, 9 colums, Table MPAT(10), a table (1), --> R0 - R8
  "5 1 1 10 2 4 0 5 v10 52 r11 # " +  // TABLE_INSERT, 2 colums, Table SKT_MPAT(4), a SKT (0) --> R9
  "4 10 10 11 10 0 r6 r10 # " +   	// SELECT, Att IdGlobal(10), equal (0), value r6 (IdCat), From Pos r10
  "1 11 11 12 r11 1 2 1 10 # " +  	// TABLE_LOOKUP, Pos R11, 1 col, Table USERDMSP(2), a TABLE(1) --> R10
  "0 12 12 2 # \u0000*/"; 					// SCAN, Table USERDMSP(2) -->R11

public static String EP_PATIENT_INSERT_AUTRE_ROLE	= // NEWSCHEMA OK // COMMENT OK // CHECK OK // TEST OK
  //Insert into matricepatient values (?,?,?,?,?,?,?,?,?)
  "/*EP \u0009 5 0 0 1 9 10 1 71 ?1 72 ?2 73 ?3 74 ?4 75 ?5 76 ?6 77 ?7 78 ?8 79 ?9 # " +
  // TABLE_INSERT, 9 colums, Table MPAT(9), a table (1), --> R0 - R8
  "5 1 1 10 2 4 0 5 v10 52 r11 # " +  // TABLE_INSERT, 2 colums, Table SKT_MPAT(4), a SKT (0) --> R9
  "4 10 10 11 52 0 r6 r10 # " +   	// SELECT, Att IdGlobal(52), equal (0), value r6 (IdCat), From Pos r10
  "1 11 11 12 r11 1 6 1 52 # " +  	// TABLE_LOOKUP, Pos R11, 1 col, Table ROLE(6), a TABLE(1) --> R10
  "0 12 12 6 # \u0000*/"; 					// SCAN, Table ROLE(6) -->R11

// CATEGORIE USER: 
public static String EP_PATIENT_INSERT_USER_USER	= // NEWSCHEMA OK // COMMENT OK // CHECK OK // TEST OK
  //Insert into matricepatient values (?,?,?,?,?,?,?,?,?)
  "/*EP \u0009 5 0 0 1 9 10 1 71 ?1 72 ?2 73 ?3 74 ?4 75 ?5 76 ?6 77 ?7 78 ?8 79 ?9 # " +
  // TABLE_INSERT, 9 colums, Table MPAT(9), a table (1), --> R0 - R8
  "5 1 1 2 2 4 0 5 r10 52 r12 # " +   // TABLE_INSERT, 2 colums, Table SKT_MPAT(4), a SKT (0)
  "7 2 2 10 4 # " +   					// FLOW
  "4 4 4 5 10 0 r4 r9 # " +   		// SELECT, Att IdGlobal(10), equal (0), value r4 (IdCat), From Pos r9
  "1 5 5 6 r10 1 2 1 10 # " +  		// TABLE_LOOKUP, Pos R10, 1 col, Table USERDMSP(2), a TABLE(1) --> R9
  "0 6 6 2 # " +  						// SCAN, Table USERDMSP(2) -->R10
  "4 10 10 11 10 0 r6 r11 # " +  		// SELECT, Att IdGlobal(10), equal (0), value r6 (IdActeur), From Pos r11
  "1 11 11 12 r12 1 2 1 10 # " +  	// TABLE_LOOKUP, Pos R12, 1 col, Table USER(2), a TABLE(1) --> R11
  "0 12 12 2 # \u0000*/";					// SCAN, Table USER(2) -->R12

public static String EP_PATIENT_INSERT_USER_ROLE	= // NEWSCHEMA OK // COMMENT OK // CHECK OK // TEST OK
  //Insert into matricepatient values (?,?,?,?,?,?,?,?,?)
  "/*EP \u0009 5 0 0 1 9 10 1 71 ?1 72 ?2 73 ?3 74 ?4 75 ?5 76 ?6 77 ?7 78 ?8 79 ?9 # " +
  // TABLE_INSERT, 9 colums, Table MPAT(9), a table (1), --> R0 - R8
  "5 1 1 2 2 4 0 5 r10 52 r12 # " +   // TABLE_INSERT, 2 colums, Table SKT_MPAT(4), a SKT (0)
  "7 2 2 10 4 # " +   				// FLOW
  "4 4 4 5 10 0 r4 r9 # " +   		// SELECT, Att IdGlobal(10), equal (0), value r4 (IdCat), From Pos r9
  "1 5 5 6 r10 1 2 1 10 # " +  		// TABLE_LOOKUP, Pos R10, 1 col, Table USERDMSP(2), a TABLE(1) --> R9
  "0 6 6 2 #" +  						// SCAN, Table USERDMSP(2) -->R10
  "4 10 10 11 52 0 r6 r11 # " +  		// SELECT, Att IdGlobal(10), equal (0), value r6 (IdActeur), From Pos r11
  "1 11 11 12 r12 1 6 1 52 # " + 		// TABLE_LOOKUP, Pos R12, 1 col, Table ROLE(6), a TABLE(1) --> R11
  "0 12 12 6 # \u0000*/";					// SCAN, Table ROLE(6) -->R12

// CATEGORIE FORMULAIRE: 
public static String EP_PATIENT_INSERT_FORMULAIRE_USER	= // NEWSCHEMA OK // COMMENT OK // CHECK OK // TEST OK
  //Insert into matricepatient values (?,?,?,?,?,?,?,?,?)
  "/*EP \u0009 5 0 0 1 9 10 1 71 ?1 72 ?2 73 ?3 74 ?4 75 ?5 76 ?6 77 ?7 78 ?8 79 ?9 # " +
  // TABLE_INSERT, 9 colums, Table MPAT(9), a table (1), --> R0 - R8
  "5 1 1 2 2 4 0 5 r10 52 r12 # " +   // TABLE_INSERT, 2 colums, Table SKT_MPAT(4), a SKT (0)
  "7 2 2 10 4 # " +  					// FLOW
  "4 4 4 5 5 0 r4 r9 # " +  			// SELECT, Att IdGlobal(5), equal (0), value r4 (IdCat), From Pos r9
  "1 5 5 6 r10 1 1 1 5 # " + 			// TABLE_LOOKUP, Pos R10, 1 col, Table FORM(1), a TABLE(1) --> R9
  "0 6 6 1 # " + 						// SCAN, Table FORM(1) -->R10
  "4 10 10 11 10 0 r6 r11 # " + 		// SELECT, Att IdGlobal(10), equal (0), value r6 (IdActeur), From Pos r11
  "1 11 11 12 r12 1 2 1 10 # " + 		// TABLE_LOOKUP, Pos R12, 1 col, Table USER(2), a TABLE(1) --> R11
  "0 12 12 2 # \u0000*/";					// SCAN, Table USER(2) -->R12

public static String EP_PATIENT_INSERT_FORMULAIRE_ROLE	= // NEWSCHEMA OK // COMMENT OK // CHECK OK // TEST OK
  //Insert into matricepatient values (?,?,?,?,?,?,?,?,?)
  "/*EP \u0009 5 0 0 1 9 10 1 71 ?1 72 ?2 73 ?3 74 ?4 75 ?5 76 ?6 77 ?7 78 ?8 79 ?9 # " +
  // TABLE_INSERT, 9 colums, Table MPAT(9), a table (1), --> R0 - R8
  "5 1 1 2 2 4 0 5 r10 52 r12 # " + 	// TABLE_INSERT, 2 colums, Table SKT_MPAT(4), a SKT (0)
  "7 2 2 10 4 # " + 					// FLOW
  "4 4 4 5 5 0 r4 r9 # " + 			// SELECT, Att IdGlobal(5), equal (0), value r4 (IdCat_Epi), From Pos r9
  "1 5 5 6 r10 1 1 1 5 # " + 			// TABLE_LOOKUP, Pos R10, 1 col, Table FORM(1), a TABLE(1) --> R9
  "0 6 6 1 # " + 						// SCAN, Table FORM(1) -->R10
  "4 10 10 11 52 0 r6 r11 # " + 		// SELECT, Att IdGlobal(52), equal (0), value r6 (IdActeur), From Pos r11
  "1 11 11 12 r12 1 6 1 52 # " + 		// TABLE_LOOKUP, Pos R12, 1 col, Table ROLE(6), a TABLE(1) --> R11
  "0 12 12 6 # \u0000*/";					// SCAN, Table ROLE(6) -->R12

// CATEGORIE EPISODE: 
public static String EP_PATIENT_INSERT_EPISODE_USER	=  // NEWSCHEMA OK // COMMENT OK // CHECK OK // TEST OK
  //Insert into matricepatient values (?,?,?,?,?,?,?,?,?)
  "/*EP \u0009 5 0 0 1 9 10 1 71 ?1 72 ?2 73 ?3 74 ?4 75 ?5 76 ?6 77 ?7 78 ?8 79 ?9 # " +
  // TABLE_INSERT, 9 colums, Table MPAT(9), a table (1), --> R0 - R8
  "5 1 1 2 2 4 0 5 r10 52 r12 # " + 	// TABLE_INSERT, 2 colums, Table SKT_MPAT(4), a SKT (0)
  "7 2 2 10 4 # " + 					// FLOW
  "4 4 4 5 0 0 r4 r9 # " + 			// SELECT, Att IdGlobal(5), equal (0), value r4 (IdCat_Epi), From Pos r9
  "1 5 5 6 r10 1 0 1 0 # " + 			// TABLE_LOOKUP, Pos R10, 1 col, Table EPI(0), a TABLE(1) --> R9
  "0 6 6 0 # " + 						// SCAN, Table EPI(0) -->R10
  "4 10 10 11 10 0 r6 r11 # " + 		// SELECT, Att IdGlobal(10), equal (0), value r6 (IdActeur), From Pos r11
  "1 11 11 12 r12 1 2 1 10 # " + 		// TABLE_LOOKUP, Pos R12, 1 col, Table USER(2), a TABLE(1) --> R11
  "0 12 12 2 # \u0000*/";					// SCAN, Table USER(2) -->R12

public static String EP_PATIENT_INSERT_EPISODE_ROLE	= // NEWSCHEMA OK // COMMENT OK // CHECK OK // TEST OK
  //Insert into matricepatient values (?,?,?,?,?,?,?,?,?)
  "/*EP \u0009 5 0 0 1 9 10 1 71 ?1 72 ?2 73 ?3 74 ?4 75 ?5 76 ?6 77 ?7 78 ?8 79 ?9 # " +
  // TABLE_INSERT, 9 colums, Table MPAT(9), a table (1), --> R0 - R8
  "5 1 1 2 2 4 0 5 r10 52 r12 # " + 	// TABLE_INSERT, 2 colums, Table SKT_MPAT(4), a SKT (0)
  "7 2 2 10 4 # " + 					// FLOW
  "4 4 4 5 0 0 r4 r9 # " + 			// SELECT, Att IdGlobal(5), equal (0), value r4 (IdCat_Epi), From Pos r9
  "1 5 5 6 r10 1 0 1 0 # " + 			// TABLE_LOOKUP, Pos R10, 1 col, Table EPI(0), a TABLE(1) --> R9
  "0 6 6 0 # " + 						// SCAN, Table EPI(0) -->R10
  "4 10 10 11 52 0 r6 r11 # " + 		// SELECT, Att IdGlobal(52), equal (0), value r6 (IdActeur), From Pos r11
  "1 11 11 12 r12 1 6 1 52 # " + 		// TABLE_LOOKUP, Pos R12, 1 col, Table ROLE(6), a TABLE(1) --> R11
  "0 12 12 6 # \u0000*/";					// SCAN, Table ROLE(6) -->R12

//---- end of INSERTS ----

public static final String EP_ROLE_SELECT_ON_TSSPT =
/* SQL : 	SELECT * FROM role WHERE TSSPT > ? */
"/*EP \u0001 " + 
"0 2 2 6 # " + /* SCAN, Table Role (6) -->R0 */
"1 1 1 2 r0 5 6 1 52 53 54 55 56 # " + /* TABLE_LOOKUP pos:R0, 5 cols, table Role(6), is_table: 1	-->R1 - R5 */
"4 0 0 1 54 1 ?1 r3 # " + /* SELECT, att: TSSPT(54), comparator: 1, parameter: ?1 (R6), from pos: R3*/
"\u0000 5 1 1 IdGlobal 1 2 Author 1 3 TSSPT 1 4 TSSanteos 0 5 Nom # " + /* META_RESULT, 5 cols, type(0-char 1-num 2-date) [out_result name] */
"\u0000*/";


}
