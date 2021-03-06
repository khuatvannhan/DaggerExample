package com.app.exampledagger.student.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.app.exampledagger.student.data.module.Student

/**
 * Data Access Object for the students table.
 */
@Dao
interface StudentsDao {
    /**
     * Select all students from the students table.
     *
     * @return all students.
     */
    @Query("SELECT * FROM students")
    fun getStudents(): LiveData<Student>

    /**
     * Select a student by id.
     *
     * @param studentId the student id.
     * @return the student with studentId.
     */
    @Query("SELECT * FROM students WHERE id = :studentId")
    fun getStudentById(studentId: Int): Student?

    /**
     * Insert a student in the database. If the student already exists, replace it.
     *
     * @param student the student to be inserted
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStudent(student: Student)

    /**
     * Update a student
     *
     * @param student student to be updated
     * @return the number of students updated. This should always be 1.
     */
    @Update
    fun updateStudent(student: Student): Int

    /**
     * Delete a student by id
     * @return the number of students deleted. This should always be 1.
     */
    @Query("DELETE FROM students WHERE id =:studentId")
    fun deleteStudentById(studentId: Int): Int

    /**
     * Delete all students.
     */
    @Query("DELETE FROM students")
    fun deleteStudents()
}
