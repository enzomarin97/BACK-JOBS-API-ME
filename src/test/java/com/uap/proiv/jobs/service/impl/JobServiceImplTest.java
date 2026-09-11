package com.uap.proiv.jobs.service.impl;

import com.uap.proiv.jobs.client.JobApiRepository;
import com.uap.proiv.jobs.dto.Job;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JobServiceImplTest {

    @Mock
    JobApiRepository jobApiRepository;

    @InjectMocks
    JobServiceImpl jobServiceImpl;

    List<Job> jobs;

    @BeforeEach
    void setUp() {
        jobs = new ArrayList<>();

        Job job1 = new Job();
        job1.setId(1);
        job1.setName("Software Engineer");
        job1.setSalary(5000);
        job1.setHours(2000);
        job1.setResources(3);
        jobs.add(job1);

        Job job2 = new Job();
        job2.setId(2);
        job2.setName("Data Analyst");
        job2.setSalary(4000);
        job2.setHours(1500);
        job2.setResources(2);
        jobs.add(job2);
    }





    @Test
    @DisplayName("getAllJobs devuelve la lista del repositorio")
    void getAllJobsReturnsRepositoryList() {
        when(jobApiRepository.getAllJobs()).thenReturn(jobs);

        List<Job> result = jobServiceImpl.getAllJobs();

        assertEquals(2, result.size()); 
        assertEquals("Software Engineer", result.get(0).getName());
        assertEquals("Data Analyst", result.get(1).getName());
        verify(jobApiRepository).getAllJobs();
    }
    @Test
    @DisplayName("verifica una excepcion en jobApiRepository")
    void getAllJob_Exception(){
        when(jobApiRepository.getAllJobs()).thenReturn(new ArrayList<>());

        assertThrows(NoSuchElementException.class, () -> {
            jobServiceImpl.getJobById(1);
        });

        verify(jobApiRepository, times(1)).getAllJobs();
    }
}