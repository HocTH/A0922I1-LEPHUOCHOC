let P = parseInt(prompt(" Input point of Physics"));
let C = parseInt(prompt(" Input point of chemistry"));
let M = parseInt(prompt(" Input point of math"));

let A = (P+C+M)/3;
let F = A.toFixed(2);
let S = A*3;
alert(" Average point of student:" + F);
alert(" Sum point of student:" + S);

