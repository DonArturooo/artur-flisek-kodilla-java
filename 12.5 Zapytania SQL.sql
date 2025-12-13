INSERT INTO POSTS (USER_ID, BODY) VALUES (3, "To jest zadanie");

UPDATE POSTS SET BODY = "To delete" WHERE USER_ID = 3 AND BODY = "To jest zadanie";

DELETE FROM POSTS WHERE BODY = "To delete";
