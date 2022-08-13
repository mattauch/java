//os servidores do JAVA são mais potentes
//os servidores do JAVAscript não processam aplicaçãoes pesadas

//carregamento assincrono -> só executa o conteúdo do javascript após o conteúdo do HTML ser carregado (content loaded = conteúdo carregado)
document.addEventListener('DOMContentLoaded', () => {

function hello(msg){
console.log(msg);
};


hello('Hello World');

//passagem de parâmetro e retorno de função
//= significa atribuição
//== significa comparação -> '0' == 0
//===significa comparação ->exatamente igual: 0===0
function par (numero){
	return numero % 2 ===0;
}

//let - local
//const - constante no programa todo - não pode alterar o valor
var ePar = par(10);
console.log(ePar); //true

function soma(num1, num2){
	return num1 + num2;
}

const total = soma(12, 13);
//total = 10; //erro
console.log(total);

if (total > 20){
	console.log('E maior que 20');
} else {
	console.log('E menor ou igual a 20');
}
/*
Math.round(x) Retorna X arredondando para o inteiro mais próximo
Math.ceil(x) Retorna X arredondando para cima o inteiro mais próximo
Math.floor(x) Retorna X arrendondando para baixo o inteiro mais próximo
Math.trunc(x) Retorna a parte inteira de x (joga fora os decimais)
Math.sign(x) Retorna se X é negtivo, null ou positivo
*/

function arredondar(numero){
	return Math.round(numero);
}
console.log(arredondar(7.9)); //8

// => arrow function = função arrow
const somaArrow = (num1, num2) => {
	return num1 + num2;
}
/* Ou dessa forma
const somaArrow = (num1, num2) => num1 + num2;
 */
 console.log(somaArrow(2, 3));

const arrIntegers = [1,2,3,4,5,6,7,8,9,10,11];
console.log(arrIntegers.length); //11
console.log(arrIntegers[0]); //1

const arrString = ['Amanda', 'SOFTGRAF', 'Rafael'];
console.log(arrString[1]); //softgraf

const arrMisto = ['Amanda', 'SOFTGRAF', 'Rafael', 1, 3, 8]; //array misto só tem no javascript
console.log(arrMisto);

console.log('=====Percorre o array usando o for')
for (i=0; i< arrMisto.length; i++){
	console.log(arrMisto[i]);
}

console.log('=====Percorre o array usando o map')
arrMisto.map(item => {
	console.log(item);
});

console.log('====Retornando o array com alteração')
const novoArr = arrIntegers.map(item => {
	return item + 2; //pega o array dos Integers e soma 2 a cada número
})
console.log(novoArr);

console.log('====Percorre o array com foreach') // não pode usar o return
arrMisto.forEach(item => {
	console.log(item)
})
});