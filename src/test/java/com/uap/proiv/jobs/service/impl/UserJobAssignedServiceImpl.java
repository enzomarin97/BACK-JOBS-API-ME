package com.uap.proiv.jobs.service.impl;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.uap.proiv.jobs.service.JobService;
import com.uap.proiv.jobs.service.UserService;

public class UserJobAssignedServiceImpl {
    @Mock
    JobService jobService;

    @Mock
    UserService userService;

    @Mock
    AssignedService assignedService;

    @InjectMocks
    UserJobAssignedServiceImpl serviceImpl;

    //vamos a tener usuarios y distintas respuestas : 

    

}
