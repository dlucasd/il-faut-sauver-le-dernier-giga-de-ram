package com.onepoint.tricourrier.entity;

public record Adresse(Long id,
                      Integer codePostal,
                      String ville,
                      String pays,
                      String ligne1,
                      String ligne2,
                      String ligne3,
                      String ligne4,
                      String ligne5,
                      String ligne6) {}
