INSERT INTO `kr.huny.site`.`user_code` (`code`, `name`) VALUES ('A', '홍길동');
INSERT INTO `kr.huny.site`.`user_code` (`code`, `name`) VALUES ('B', '이순신');
INSERT INTO `kr.huny.site`.`user_code` (`code`, `name`) VALUES ('C', '연개소문');


INSERT INTO `kr.huny.site`.`authority` (`authority`, `authority_name`) VALUES (1, '방문자');
INSERT INTO `kr.huny.site`.`authority` (`authority`, `authority_name`) VALUES (10, '일반');
INSERT INTO `kr.huny.site`.`authority` (`authority`, `authority_name`) VALUES (100, '관리자');
INSERT INTO `kr.huny.site`.`authority` (`authority`, `authority_name`) VALUES (255, '슈퍼관리자');

INSERT INTO `kr.huny.site`.`user_authority` (`authority`, `user_no`) VALUES (10, 3);
INSERT INTO `kr.huny.site`.`user_authority` (`authority`, `user_no`) VALUES (100, 3);
INSERT INTO `kr.huny.site`.`user_authority` (`authority`, `user_no`) VALUES (255, 3);