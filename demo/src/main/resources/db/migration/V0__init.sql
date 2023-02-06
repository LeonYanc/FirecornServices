create table if not exists url (
                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                     longurl varchar(255),
                     shorturl varchar(255)
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;