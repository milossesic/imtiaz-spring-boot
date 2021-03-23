insert into employee (employee_id, first_name, last_name, email) values (1,'John','John','John@john');
insert into employee (employee_id, first_name, last_name, email) values (2,'Mike','John','John@john');
insert into employee (employee_id, first_name, last_name, email) values (3,'Steve','John','John@john');
insert into employee (employee_id, first_name, last_name, email) values (4,'Ronald','John','John@john');
insert into employee (employee_id, first_name, last_name, email) values (5,'Jim','John','John@john');
insert into employee (employee_id, first_name, last_name, email) values (6,'Peter','John','John@john');
insert into employee (employee_id, first_name, last_name, email) values (7,'Richard','John','John@john');
insert into employee (employee_id, first_name, last_name, email) values (8,'Bvana','John','John@john');
insert into employee (employee_id, first_name, last_name, email) values (9,'Toni','John','John@john');

insert into project (project_id, name, stage, description) values (1000,'foodbar','INPROGRESS','foodbar');
insert into project (project_id, name, stage, description) values (1001,'EmployeeBudget','COMPLETED','foodbar');
insert into project (project_id, name, stage, description) values (1002,'Office Reconstruction','INPROGRESS','foodbar');
insert into project (project_id, name, stage, description) values (1003,'Improve Security','NOTSTARTED','foodbar');

insert into project_employee (employee_id, project_id) values (1,1000);
insert into project_employee (employee_id, project_id) values (1,1001);
insert into project_employee (employee_id, project_id) values (1,1002);
insert into project_employee (employee_id, project_id) values (1,1000);

insert into project_employee (employee_id, project_id) values (3,1000);
insert into project_employee (employee_id, project_id) values (3,1000);

insert into project_employee (employee_id, project_id) values (1,1001);
insert into project_employee (employee_id, project_id) values (1,1002);

insert into project_employee (employee_id, project_id) values (6,1002);
insert into project_employee (employee_id, project_id) values (6,1003);
insert into project_employee (employee_id, project_id) values (6,1002);
insert into project_employee (employee_id, project_id) values (6,1003);
