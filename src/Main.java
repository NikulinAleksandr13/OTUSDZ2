import dataobject.Curator;
import dataobject.Group;
import dataobject.Student;
import db.DBConnector;
import tables.AbsTable;
import tables.CuratorsTable;
import tables.GroupsTable;
import tables.StudentsTable;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AbsTable studentsTable = new StudentsTable();
        AbsTable curatorsTable = new CuratorsTable();
        AbsTable groupsTable = new GroupsTable();

        try {
            // Работа со студентами
            List<String> columnsStudentTable = new ArrayList<>();
            columnsStudentTable.add("id INT PRIMARY KEY");
            columnsStudentTable.add("fio VARCHAR(50)");
            columnsStudentTable.add("sex VARCHAR(1)");
            columnsStudentTable.add("id_group INT");
            studentsTable.create(columnsStudentTable);

            List<String> columnsStudent = new ArrayList<>();
            columnsStudent.add("id");
            columnsStudent.add("fio");
            columnsStudent.add("sex");
            columnsStudent.add("id_group");

            studentsTable.insert(columnsStudent, new Student(1, "Masha Kulik", "w", 1));
            studentsTable.insert(columnsStudent, new Student(2, "Ivan Ivanov", "m", 2));
            studentsTable.insert(columnsStudent, new Student(3, "Petr Petrov", "m", 3));
            studentsTable.insert(columnsStudent, new Student(4, "Ted Kuk", "m", 1));
            studentsTable.insert(columnsStudent, new Student(5, "Berta Smoke", "w", 1));
            studentsTable.insert(columnsStudent, new Student(6, "Kate Morgan", "w", 3));
            studentsTable.insert(columnsStudent, new Student(7, "Sasha Sulim", "w", 2));
            studentsTable.insert(columnsStudent, new Student(8, "Linda Kash", "w", 3));
            studentsTable.insert(columnsStudent, new Student(9, "Margo Pik", "w", 1));
            studentsTable.insert(columnsStudent, new Student(10, "Robert Zain", "m", 1));
            studentsTable.insert(columnsStudent, new Student(11, "Chris Bern", "m", 2));
            studentsTable.insert(columnsStudent, new Student(12, "Sam Tachirov", "m", 3));
            studentsTable.insert(columnsStudent, new Student(13, "Roy Kin", "m", 2));
            studentsTable.insert(columnsStudent, new Student(14, "Ben Wait", "m", 3));
            studentsTable.insert(columnsStudent, new Student(15, "Viktoria Slim", "w", 2));

            // Работа с группами
            List<String> columnsGroupTable = new ArrayList<>();
            columnsGroupTable.add("id INT PRIMARY KEY");
            columnsGroupTable.add("name_group VARCHAR(150)");
            columnsGroupTable.add("id_curator INT");
            groupsTable.create(columnsGroupTable);

            List<String> columnsGroup = new ArrayList<>();
            columnsGroup.add("id");
            columnsGroup.add("name_group");
            columnsGroup.add("id_curator");

            groupsTable.insert(columnsGroup, new Group(1, "Critical", 1));
            groupsTable.insert(columnsGroup, new Group(2, "High", 4));
            groupsTable.insert(columnsGroup, new Group(3, "Trivial", 3));

            // Работа с кураторами
            List<String> columnsCuratorTable = new ArrayList<>();
            columnsCuratorTable.add("id INT PRIMARY KEY");
            columnsCuratorTable.add("fio VARCHAR(50)");
            curatorsTable.create(columnsCuratorTable);

            List<String> columnsCurator = new ArrayList<>();
            columnsCurator.add("id");
            columnsCurator.add("fio");

            curatorsTable.insert(columnsCurator, new Curator(1, "Tarasova Ekaterina"));
            curatorsTable.insert(columnsCurator, new Curator(2, "Jonson Mark"));
            curatorsTable.insert(columnsCurator, new Curator(3, "Pushkin Aleks"));
            curatorsTable.insert(columnsCurator, new Curator(4, "Sidorova Anastasia"));

            studentsTable.resultDisplay(studentsTable.selectAll("students.fio, groups.name_group, curators.fio", "students","groups", "students.id_group",
                    "groups.id", "curators", "groups.id_curator", "curators.id"));

             studentsTable.selectStudentsCountSex("fio", "sex", "m");
            studentsTable.selectStudentsCountSex("fio", "sex", "w");

            // Список без изменения
            groupsTable.selectStudentsCountSex("*", "id", "1");

            groupsTable.updateGroupsUpdateCurators("id_curator", "2", "id", "1");

            // Список после изменения кураторов
            groupsTable.selectStudentsCountSex("*", "id", "1");

            groupsTable.selectGroupsWithCurators("groups.name_group, curators.fio", "id_curator", "curators", "id");

            studentsTable.selectStudentsTheGroups("fio", "id_group", "id", "groups", "name_group", "Critical");


        } finally {
//        studentsTable.delete();
//        curatorsTable.delete();
//        groupsTable.delete();
       DBConnector.close();
        }
    }
}
