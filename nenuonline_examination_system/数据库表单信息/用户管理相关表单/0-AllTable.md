
# 用户管理表

## userpower


| 序号 | 列名        | 说明     | 数据类型 | 长度 | 主键 | 是否为空 |
| ---- | ----------- | -------- | -------- | ---- | ---- | -------- |
| 1    | PowerID     | 权限编号 | INT      |      | 是   | 否       |
| 2    | PowerDegree | 权限等级 | INT      |      | 否   | 否       |
| 3    | PowerName   | 权限名称 | VARCHAR  |      | 否   | 否       |


## admin

| 序号 | 列名      | 说明     | 数据类型 | 长度 | 主键 | 是否为空 |
| ---- | --------- | -------- | -------- | ---- | ---- | -------- |
| 1    | Uid       | 主键     | INT      |      | 是   | 否       |
| 2    | AdminID   | 人员编号 | INT      |      | 否   | 否       |
| 3    | AdminName | 用户名   | VARCHAR  |      | 否   | 否       |
| 4    | AdminPwd  | 用户密码 | VARCHAR  |      | 否   | 否       |


## affairs

| 序号 | 列名          | 说明     | 数据类型 | 长度 | 主键 | 是否为空 |
| ---- | ------------- | -------- | -------- | ---- | ---- | -------- |
| 1    | Uid           | 主键     | INT      |      | 是   | 否       |
| 2    | AffairsID     | 教务编号 | INT      |      | 否   | 否       |
| 3    | AffairsName   | 用户名   | VARCHAR  |      | 否   | 否       |
| 4    | AffairsPwd    | 用户密码 | VARCHAR  |      | 否   | 否       |
| 5    | AffairsGrade  | 所在年级 | INT      |      | 否   | 否       |
| 6    | AffairsSchool | 所属学校 | VARCHAR  |      | 否   | 否       |


## teacher

| 序号 | 列名          | 说明     | 数据类型 | 长度 | 主键 | 是否为空 |
| ---- | ------------- | -------- | -------- | ---- | ---- | -------- |
| 1    | Uid           | 主键     | INT      |      | 是   | 否       |
| 2    | TeacherID     | 教师编号 | INT      |      | 否   | 否       |
| 3    | TeacherName   | 教师名   | VARCHAR  |      | 否   | 否       |
| 4    | TeacherPwd    | 用户密码 | VARCHAR  |      | 否   | 否       |
| 5    | Tel           | 电话     | INT      |      | 否   | 是       |
| 6    | TeacherAdr    | 通讯地址 | VARCHAR  |      | 否   | 是       |
| 7    | Introduction  | 简介     | TEXT     |      | 否   | 是       |
| 8    | TeacherSchool | 所属学校 | VARCHAR  |      | 否   | 否       |


## student



| 序号 | 列名          | 说明     | 数据类型 | 长度 | 主键 | 是否为空 |
| ---- | ------------- | -------- | -------- | ---- | ---- | -------- |
| 1    | Uid           | 主键     | INT      |      | 是   | 否       |
| 2    | StudentID     | 学号     | INT      |      | 否   | 否       |
| 3    | StudentName   | 姓名     | VARCHAR  |      | 否   | 否       |
| 4    | Sex           | 性别     | VARCHAR  |      | 否   | 否       |
| 5    | StudentPwd    | 密码     | INT      |      | 否   | 否       |
| 6    | StudentClass  | 班级     | VARCHAR  |      | 否   | 否       |
| 7    | StudentGrade  | 年级     | VARCHAR  |      | 否   | 否       |
| 8    | StudentSchool | 所属学校 | VARCHAR  |      | 否   | 否       |
| 9    | Introduction  | 简介     | TEXT     |      | 否   | 是       |








