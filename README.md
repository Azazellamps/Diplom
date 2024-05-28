# Тестирование мобильного приложения «Мобильный хоспис»
## Запуск приложения и тестов, формирование отчета.
- Открыть `git bash`.
- Склонировать репозиторий `git clone` `https://github.com/Azazellamps/Diplom`.
- Открыть проект `fmh-android` в Android Studio.
- Запустить эмулятор (API 29) или подключить устройство для тестирования (не ниже API 29).
- Запустить тесты во вкладке Run нажать: `Run` `'Tests in 'ru.iteco.fmhandroid.ui.tests"` .
- После прохождения всех тестов скопировать папку `allure-results` в проект с устройства, которую можно найти по пути: `/data/data/ru.iteco.fmhandroid/files/allure-results` (при помощи Device Explorer).
- Выполните в терминале команду `allure serve` для просмотра отчетов.
