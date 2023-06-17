package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_oneNotCompletedTask_returnHundredZero() {
        //when
        val tasks = listOf<Task>(
                Task("test", "test", false)
        )
        //given
        val result = getActiveAndCompletedStats(tasks)
        //then
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(100f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_oneNotCompletedTask_returnZeroHundred() {
        //when
        val tasks = listOf<Task>(
                Task("test", "test", true)
        )
        //given
        val result = getActiveAndCompletedStats(tasks)
        //then
        assertEquals(100f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_TwoCompletedTask_returnZeroHundred() {
        //when
        val tasks = listOf<Task>(
                Task("test1", "test", true),
                Task("test2", "test", true),
                Task("test3", "test", false),
                Task("test4", "test", false),
                Task("test5", "test", false)
        )
        //given
        val result = getActiveAndCompletedStats(tasks)
        //then
        assertEquals(40f, result.completedTasksPercent)
        assertEquals(60f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_NoTask_returnZeroZero() {
        //when
        val tasks = listOf<Task>(

        )
        //given
        val result = getActiveAndCompletedStats(emptyList())
        //then
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }
    @Test
    fun getActiveAndCompletedStats_null_returnZeroZero() {
        //when
        val tasks = listOf<Task>(

        )
        //given
        val result = getActiveAndCompletedStats(null)
        //then
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }
}

