package com.epam.kolbasov.springadv.util.pdf

interface IReportGenerator {
    ByteArrayInputStream generate(Collection<?> collection);
}