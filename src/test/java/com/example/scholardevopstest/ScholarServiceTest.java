package com.example.scholardevopstest;

import com.example.scholardevopstest.entities.Scholar;
import com.example.scholardevopstest.repositories.ScholarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class ScholarServiceTest {

    @InjectMocks
    ScholarService scholarService;
    @Mock
    private ScholarRepository scholarRepository;


    @Test
    void findAllScholars() {
        Mockito.when(scholarRepository.findAll()).thenReturn(new ArrayList<>());
        List<Scholar> expected =new ArrayList<>();
        List<Scholar> result = scholarService.findAllScholars();
        Assertions.assertEquals(expected,result);
    }

    @Test
    void findScholarById() {
        Scholar expected =  mock(Scholar.class);
        Mockito.when(scholarRepository.findById("1234")).thenReturn(Optional.ofNullable(expected));
        Optional<Scholar> result = scholarService.findScholarById("1234");
        Assertions.assertEquals(Optional.ofNullable(expected),result);
    }
}