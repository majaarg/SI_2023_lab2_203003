# Втора лабораториска вежба по Софтверско инженерство

## Маја Аргирова, бр. на индекс 203003

### Група на код: 
Ја добив групата на код 5

### Control Flow Graph

![ControlFlowGraph drawio](https://github.com/majaarg/SI_2023_lab2_203003/assets/86935512/2ade999c-33f8-4b75-bdb9-ff77f26a7c10)

### Цикломатска комплексност

Формула: 40 ребра - 29 јазли + 2 = 11 + 2 = 13 ?
предикатни јазли(тие што се разгрануваат) --> 10+1=11 ?

Цикломатската комплексност на овој код е 13, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во случајoв P=12, па цикломатската комплексност изнесува 13.

### Тест случаи според критериумот Every Branch

1. User == null --> со овој тест случај се опфаќаат само branch 1 и 2, затоа што ќе влезе во првиот if, но уште на почеток првиот услов не е исполнет и ќе фрли exception. Така што резултатот од овој тест ќе биде: "Mandatory information missing!". Не се внесува корисник и целта со овој тест е да се покаже токму тоа.  

2. Username == password --> Во овој тест случај се внесуваат исто корисничко име и пасворд и ссо него се покажува дека при внес на истиот ќе се по 

3. Password = maja argirova (password има празно место) --> Со овој тест случај се проверува случајот кога во пасвордот како карактер имаме празно место и со истиот се тестира содржината на пасвордот. При извршување на тестот, на екран се печати порака "Vnesen e password koj sodrzi prazno mesto.".

4. User user = new User(username: null, password: "maja123@", email: "maja@example.com") --> Со овој тест случај се внесува валиден пасворд кој ги содржи сите потребни карактери, исто така имаме и валиден внес за емаил со @ и . , меѓутоа не нема внесено постоечки корисник и целта е тесстот тоа да го покаже. 

### Тест случаи според критериумот Multiple Condition --> if (user==null || user.getPassword()==null || user.getEmail()==null)
  1. T || T || F
  Според овој тест случај, ако вредноста за user и password е true, односно е различна од null, а ако последниот дел од условот што се однесува на email е false, односно е null, тест случајот нема да помине поради последниот дел од условот што не е исполнет, т.е. делот за емаил.
  2. T || F || T/F
  Според овој тест случај, доколку вредноста за user е true, ќе помине на следниот дел од условот, но ќе запре на делот за password, затоа што е false, односно нема вредност. Тука веднаш ќе падне тест случајот и нема ни да продолжи понатаму на делот за емаил.
  3. F || F/T || F/T
  Според овој тест случај, програмата ќе падне уште на почетокот, кога ќе дојде до делот за user, бидејќи тој дел од условот не е исполнет и нема ни да продолжи понатаму.

### Објаснување на напишаните unit tests
