import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe Estudante que possui os atributos matricula e curso gerados
 * aleatoriamente.
 * 
 * @author Aline Vieira de Melo
 * @Reviewed by Williamson Silva
 * @Reviewed by O GRUPO 3Reviewed again by o Probrema
 */
public class Estudante implements Comparable<Estudante> {
	private int matricula;
	private String curso;

	private static int nEstudantes = 0;
	private static Random geradorMatricula = new Random();
	private static Random geradorCurso = new Random();
	private static ArrayList<Integer> arrayzinho = new ArrayList<>();

	public Estudante() {
		geraMatricula();
		geraCurso();
	}

	/**
	 * Gera o número de matricula de forma aleatória
	 */
	// Gustavo é agro
	// Gustavo é top
	// Gustavo é tudo
	
	public static int[] randomizaVetor(int[] vetor1) {
        Random random = new Random();

        for (int i = 0; i < vetor1.length; i++) {
            boolean novoNumero = false;
            int numero = -1;
            while (!novoNumero) {
                numero = random.nextInt(vetor1.length + 1); 
                novoNumero = verificarExistencia(numero, vetor1);
            }
            vetor1[i] = numero;
        }
        return vetor1;
    }
	
	public static boolean verificarExistencia(int numero, int[] vetor1) {
        for (int i = 0; i < vetor1.length; i++) {
            if (numero == vetor1[i]) {
                return false;
            }
        }
        return true;
    }
	
	private void geraRandom() {
		for (int i = 0; i < 100000; i++) {
			arrayzinho.add(i);
		}
		Collections.shuffle(arrayzinho);

	}

	private void geraMatricula() {
		if (nEstudantes % 2 == 0) {
			this.matricula = 202050000 - arrayzinho.get(0);
			arrayzinho.remove(0);
		} else{
			this.matricula = 202050000 + arrayzinho.get(0);
			arrayzinho.remove(0);
		}
		nEstudantes++;

	}

	/**
	 * Gera o curso aleatoriamente
	 */
	private void geraCurso() {
		int c = geradorCurso.nextInt(7);
		switch (c) {
			case 0:
				this.curso = "Ciencia da Computacao";
				break;
			case 1:
				this.curso = "Engenharia Agricola";
				break;
			case 2:
				this.curso = "Engenharia Civil";
				break;
			case 3:
				this.curso = "Engenharia de Software";
				break;
			case 4:
				this.curso = "Engenharia de Telecomunicacoes";
				break;
			case 5:
				this.curso = "Engenharia Eletrica";
				break;
			case 6:
				this.curso = "Engenharia Mecanica";
				break;
			default:
				new Exception("ERRO NA GERA��O DO CURSO");
		}
	}

	/**
	 * @return o curso
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * @return o número de matricula
	 */
	public int getMatricula() {
		return matricula;
	}

	/**
	 * @return True se o curso é Engenharia de Software e False caso contrário
	 */
	public boolean isCursoES() {
		return (curso.equalsIgnoreCase("Engenharia de Software"));
	}

	/**
	 * Compara se a matricula do Estudante informado por parâmetro com a matricula
	 * deste estudante.
	 * 
	 * @param e Estudante a ser comparado
	 * @return 1 se a matricula deste estudante é maior que a do estudante passado
	 *         por parâmetro, 0 se é igual e -1 se for menor.
	 */
	@Override
	public int compareTo(Estudante e) {
		if (this.matricula > e.getMatricula())
			return 1;
		else if (this.matricula < e.getMatricula())
			return -1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return "Estudante matricula: " + this.matricula + " curso: " + this.curso;
	}

}
