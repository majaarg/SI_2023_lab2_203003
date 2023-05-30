# Втора лабораториска вежба по Софтверско инженерство

## Маја Аргирова, бр. на индекс 203003

### Група на код: 
Ја добив групата на код 5

### Control Flow Graph

Фотографија од control flow graph-ot

### Цикломатска комплексност

Формула: 40 ребра - 29 јазли + 2 = 11 + 2 = 13 ?
предикатни јазли(тие што се разгрануваат) --> 10+1=11 ?

Цикломатската комплексност на овој код е 13, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во случајoв P=12, па цикломатската комплексност изнесува 13.

### Тест случаи според критериумот Every Branch
1. User==null --> со овој тест case се опфаќаат само branch 1 и 2, затоа што ќе влезе во привот if, но уште на почеток првиот услов не е исполнет и ќе фрли exception. Така што резултатот од овој тест ќе биде: "Mandatory information missing!" . 
2. user = User(email = "user@example.com", password = "password", username = "user"), 
   allUsers = [User(email = "existing@example.com", password = "existing", username = "existing")]
   Со овој тест case, резултатот ќе биде "false" од две причини. Од една страна пасвордот кој се внесува нњ содржи специјални карактери, а од друга страна, меилот и корисничкото име кои се внесуваат на тековниот кориснки веќе постојат во листата на сите корисници.
3. User user = new User();
user.setPassword("password");
user.setEmail("test@example.com");
List<User> allUsers = new ArrayList<>();

boolean result = function(user, allUsers);
// Expected result: false
*** ги имаме сите потребни информации и корисничкото име не е null вредност. Сепак, лозинката го содржи корисничкото име и е помала од 8 знаци, така што функцијата треба да врати неточно.
  
4. User user = new User();
user.setPassword("password");
user.setUsername(null);
List<User> allUsers = new ArrayList<>();

boolean result = function(user, allUsers);
// Expected result: true
*** Во овој тест случај, корисничкото име е нула, така што се поставува на адресата за е-пошта. Лозинката не го содржи корисничкото име и има должина поголема од 8 знаци. Нема специјални знаци во лозинката. Бидејќи адресата на е-пошта не е веќе присутна во allUsersсписокот, функцијата треба да се врати како точно.
  
5. User user = new User();
user.setPassword("password");
user.setEmail("test@example.com");
List<User> allUsers = new ArrayList<>();
allUsers.add(user); // Add the user to the allUsers list

boolean result = function(user, allUsers);
// Expected result: false
*** Во овој тест случај, е-поштата на корисникот е веќе присутна во allUsersсписокот. Затоа, sameпроменливата ќе се зголеми, а функцијата треба да се врати false.
  
6. User user = new User();
user.setPassword("pass@123");
user.setEmail("test@example.com");
List<User> allUsers = new ArrayList<>();

boolean result = function(user, allUsers);
// Expected result: true
*** Во овој тест случај, корисничкиот објект содржи валидна лозинка која не е помала од 8 знаци и не го содржи корисничкото име. Лозинката содржи посебен знак. Бидејќи адресата на е-пошта не е веќе присутна во allUsersсписокот, функцијата треба да се врати како точно.
....

### Тест случаи според критериумот Multiple Condition --> if (user==null || user.getPassword()==null || user.getEmail()==null)
  1. T || T || F
  Според овој тест случај, ако вредноста за user и password е true, односно е различна од null, а ако последниот дел од условот што се однесува на email е false, односно е null, тест случајот нема да помине поради последниот дел од условот што не е исполнет, т.е. делот за емаил.
  2. T || F || T/F
  Според овој тест случај, доколку вредноста за user е true, ќе помине на следниот дел од условот, но ќе запре на делот за password, затоа што е false, односно нема вредност. Тука веднаш ќе падне тест случајот и нема ни да продолжи понатаму на делот за емаил.
  3. F || F/T || F/T
  Според овој тест случај, програмата ќе падне уште на почетокот, кога ќе дојде до делот за user, бидејќи тој дел од условот не е исполнет и нема ни да продолжи понатаму.
  
....

### Објаснување на напишаните unit tests
... ...
