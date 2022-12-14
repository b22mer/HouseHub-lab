use
    myhouse;

--     member table
create table if not exists member
(
    name         varchar(50),
    id           varchar(50),
    position     varchar(50),
    pw           varchar(50),
    email        varchar(50),
    phone_number varchar(50),
    admin        int not null,
    PRIMARY KEY (`id`)
);

create table if not exists favoriteLoc
(
    `idx`       int auto_increment not null primary key,
    `id`        varchar(50)        not null,
    `dongCode`  varchar(20)        not null,
    constraint `fk_member_favoriteLoc`
        foreign key (`id`)
            references `member` (`id`)
            on delete cascade
            on update cascade
);

alter table favoriteLoc
    add foreign key (dongCode) references dongcode (dongCode);


-- Security table
create table if not exists SecurityVO
(
    userId varchar(50),
    uuid   varchar(50),
    salt   varchar(50)
);
CREATE TABLE if not exists board
(
    `code`         varchar(50) NOT NULL,
    `article_no`   int         not null AUTO_INCREMENT,
    `groupOrd`     int              DEFAULT NULL,
    `groupLayer`   int              DEFAULT NULL,
    `title`        varchar(250)     DEFAULT NULL,
    `content`      longtext,
    `writer`       varchar(50)      DEFAULT NULL,
    hit            int,
    `reg_datetime` datetime         DEFAULT NULL,
    `id`           VARCHAR(16) NULL DEFAULT NULL,
    PRIMARY KEY (`article_no`),
    INDEX `board_to_member_id_fk` (`id` ASC) VISIBLE,
    CONSTRAINT `board_to_member_id_fk`
        FOREIGN KEY (`id`)
            REFERENCES `myhouse`.`member` (`id`)
            on delete cascade
            on update cascade
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;