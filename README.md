# com.itmo.reg

Система on-line регистрации слушателей на обучение

Исходные данные: 
* данные о кандидате на регистрацию (ФИО, e-mail); 
* перечень специализаций для выбора; 
* дата начала специализации; 
* форма оплаты.

Ключевые настройки БД в файле application.properties.

В указанной в настройках пустой БД создаются таблицы после первого запуска. Далее потребуется выполнить SQL-скрипт добавления ролей

INSERT INTO t_role(id, name) VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');

Далее можно создать первую УЗ. Т.к. все УЗ создаются с минимальной ролью пользователя надо добавить\повысить права до администратора.

Это делается, SQL-запросом:

INSERT INTO t_user_roles(user_id, roles_id) VALUES (1, 2);

Форма оплаты на данный момент вводиться пользователем произвольно как текст. Номер телефон пока не указывается.
