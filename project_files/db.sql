
    create table cashier (
       id bigint not null,
        name varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table director (
       id bigint not null,
        username varchar(255),
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table grade_report (
       id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table profile (
       id bigint not null,
        date_of_birth varchar(255),
        email varchar(255),
        fathers_name varchar(255),
        grade integer,
        name varchar(255),
        pic_url varchar(255),
        section integer,
        sex integer,
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table staff (
       id bigint not null,
        job_title integer,
        lastname varchar(255),
        name varchar(255),
        password varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table staff_teachers (
       staff_id bigint not null,
        teachers_id bigint not null
    ) engine=InnoDB

    create table student (
       id bigint not null,
        password varchar(255),
        username varchar(255),
        profile_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table student_grade_report (
       student_id bigint not null,
        grade_report_id bigint not null
    ) engine=InnoDB

    create table teacher (
       id bigint not null,
        assigned_class integer,
        subject integer,
        primary key (id)
    ) engine=InnoDB

    create table teacher_grade_reports (
       teacher_id bigint not null,
        grade_reports_id bigint not null
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        enabled integer,
        password varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table staff_teachers 
       add constraint UK_1r03oksn3a0cd74me04rc7jiq unique (teachers_id)

    alter table student_grade_report 
       add constraint UK_6uel7aml2wrdxots63ipsl0ei unique (grade_report_id)

    alter table staff_teachers 
       add constraint FK84juh0tsuyiitb93b3y7q5o0s 
       foreign key (teachers_id) 
       references teacher (id)

    alter table staff_teachers 
       add constraint FKkhmy389bkhbd8numctf70w7jw 
       foreign key (staff_id) 
       references staff (id)

    alter table student 
       add constraint FKrka4ao1s80dn9px2fllkmke03 
       foreign key (profile_id) 
       references profile (id)

    alter table student_grade_report 
       add constraint FKl7ycvob2wssx10mqp325h47bi 
       foreign key (grade_report_id) 
       references grade_report (id)

    alter table student_grade_report 
       add constraint FK5nhird0go8uwi5o4rc0n6s8yx 
       foreign key (student_id) 
       references student (id)

    alter table teacher_grade_reports 
       add constraint FK7auc636dep2k5jyrm7nq95y76 
       foreign key (grade_reports_id) 
       references grade_report (id)

    alter table teacher_grade_reports 
       add constraint FK9aqo834sk48whse04ub08eneg 
       foreign key (teacher_id) 
       references teacher (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table cashier (
       id bigint not null,
        name varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table director (
       id bigint not null,
        name varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table grade_report (
       id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table profile (
       id bigint not null,
        date_of_birth varchar(255),
        email varchar(255),
        fathers_name varchar(255),
        grade integer,
        name varchar(255),
        pic_url varchar(255),
        section integer,
        sex integer,
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table staff (
       id bigint not null,
        job_title integer,
        lastname varchar(255),
        name varchar(255),
        password varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table staff_teachers (
       staff_id bigint not null,
        teachers_id bigint not null
    ) engine=InnoDB

    create table student (
       id bigint not null,
        password varchar(255),
        username varchar(255),
        profile_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table student_grade_report (
       student_id bigint not null,
        grade_report_id bigint not null
    ) engine=InnoDB

    create table teacher (
       id bigint not null,
        assigned_class integer,
        subject integer,
        staff_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table teacher_grade_reports (
       teacher_id bigint not null,
        grade_reports_id bigint not null
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        enabled integer,
        password varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table staff_teachers 
       add constraint UK_1r03oksn3a0cd74me04rc7jiq unique (teachers_id)

    alter table student_grade_report 
       add constraint UK_6uel7aml2wrdxots63ipsl0ei unique (grade_report_id)

    alter table staff_teachers 
       add constraint FK84juh0tsuyiitb93b3y7q5o0s 
       foreign key (teachers_id) 
       references teacher (id)

    alter table staff_teachers 
       add constraint FKkhmy389bkhbd8numctf70w7jw 
       foreign key (staff_id) 
       references staff (id)

    alter table student 
       add constraint FKrka4ao1s80dn9px2fllkmke03 
       foreign key (profile_id) 
       references profile (id)

    alter table student_grade_report 
       add constraint FKl7ycvob2wssx10mqp325h47bi 
       foreign key (grade_report_id) 
       references grade_report (id)

    alter table student_grade_report 
       add constraint FK5nhird0go8uwi5o4rc0n6s8yx 
       foreign key (student_id) 
       references student (id)

    alter table teacher 
       add constraint FKjm4mj1kty202th3dolkhxkt8k 
       foreign key (staff_id) 
       references staff (id)

    alter table teacher_grade_reports 
       add constraint FK7auc636dep2k5jyrm7nq95y76 
       foreign key (grade_reports_id) 
       references grade_report (id)

    alter table teacher_grade_reports 
       add constraint FK9aqo834sk48whse04ub08eneg 
       foreign key (teacher_id) 
       references teacher (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)
