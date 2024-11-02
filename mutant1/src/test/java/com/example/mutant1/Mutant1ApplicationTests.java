package com.example.mutant1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import service1.MutantService;

@SpringBootTest
class Mutant1ApplicationTests {

	@Autowired
	private MutantService service;

	@Test
	void contextLoads() {
	}

	@Test
	public void arrayVacio() {
		String[] dna = {};
		Assertions.assertThrows(NullPointerException.class, () -> {
			service.isMutant(dna);
		});
	}

	@Test
	public void arrayNxM() {
		String[] dna = {
				"BBBBB",
				"BBBBB",
				"BBBBB",
				"BBBBB"
		};
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			service.isMutant(dna);
		});
	}

	@Test
	public void arrayNumeros() {
		String[] dna = {
				"5555",
				"5555",
				"5555",
				"5555"
		};
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.isMutant(dna);
		});
	}

	@Test
	public void recibirNull() {
		Assertions.assertThrows(NullPointerException.class, () -> service.isMutant(null));
	}

	@Test
	public void arrayOtrasLetras() {
		String[] dna = {
				"BBBB",
				"HHHH",
				"BBBB",
				"HHHH"
		};
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.isMutant(dna);
		});
	}

	@Test
	public void prueba1() {
		String[] dna = {
				"AAAA",
				"CCCC",
				"TCAG",
				"GGTC"
		};
		Assertions.assertFalse(service.isMutant(dna));
	}

	@Test
	public void prueba2() {
		String[] dna = {
				"AAAT",
				"AACC",
				"AAAC",
				"CGGG"
		};
		Assertions.assertFalse(service.isMutant(dna));
	}

	@Test
	public void prueba3() {
		String[] dna = {
				"TGAC",
				"AGCC",
				"TGAC",
				"GGTC"
		};
		Assertions.assertTrue(service.isMutant(dna));
	}

	@Test
	public void prueba4() {
		String[] dna = {
				"AAAA",
				"AAAA",
				"AAAA",
				"AAAA"
		};
		Assertions.assertTrue(service.isMutant(dna));
	}

	@Test
	public void prueba5() {
		String[] dna = {
				"TGAC",
				"ATCC",
				"TAAG",
				"GGTC"
		};
		Assertions.assertFalse(service.isMutant(dna));
	}

	@Test
	public void prueba6() {
		String[] dna = {
				"TCGGGTGAT",
				"TGATCCTTT",
				"TACGAGTGA",
				"AAATGTACG",
				"ACGAGTGCT",
				"AGACACATG",
				"GAATTCCAA",
				"ACTACGACC",
				"TGAGTATCC"
		};
		Assertions.assertTrue(service.isMutant(dna));
	}

	@Test
	public void prueba7() {
		String[] dna = {
				"TTTTTTTTT",
				"TTTTTTTTT",
				"TTTTTTTTT",
				"TTTTTTTTT",
				"CCGACCAGT",
				"GGCACTCCA",
				"AGGACACTA",
				"CAAAGGCAT",
				"GCAGTCCCC"
		};
		Assertions.assertTrue(service.isMutant(dna));
	}
}
