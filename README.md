# ubic_test_task
Надо написать spring boot приложение,
Цель - управление задачами aka ToDO: мы хотим добавлять задачи в список, просматривать состояние списка, помечать задачи завершенными
Задача - это штука, в которой есть описание и id
требования к апи такие
- должен быть rest controller, по пути /task/ со следующими функциями
  - GET / - получить список задач (опционально можно сделать фильтр по завершенным)
  - POST / - добавить задачу
  - PUT /mark/$id/ - пометить задачу сделанной
  Внешнее ограничение - параметр запуска ограничивающий количество незавершенных задач в списке, если достигнут, то задачу поставить нельзя.
  Требований к хранилищу в части реализации и персистенности нет. Фронт делать не нужно.
  Наши программисты оценивают необходимое время ее решения от часа до двух. 
В качестве результата мы ожидаем исходники (maven проект целиком, можно архивом) и “цифра” -  сколько чистого времени ушло на задачу.

Заранее спасибо.
