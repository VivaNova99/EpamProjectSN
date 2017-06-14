
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <title></title>

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Spirax">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <style>
        <%@include file="../../styles/main.css" %>
        <%@include file="../../styles/forum-themes.css" %>
    </style>

</head>
<body>

<section class="forum-themes">

    <ul>
        <li>
            <ul>
                <li><h2>Административный</h2></li>
                <li><a href="forum-this-theme?this_forum_theme_order=310&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Наш форум</h3></a></li>
                <li><p>Обсуждение работы форума.
                    Проблемы и их решения</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=320&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Конкурсы</h3></a></li>
                <li><p>Конкурсы для наших форумчан</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=330&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Опросник</h3></a></li>
                <li><p>Нам важно ваше мнение</p></li>
            </ul>
        </li>

        <li>
            <ul>
                <li><h2>Свадебная тематика</h2></li>
                <li><a href="forum-this-theme?this_forum_theme_order=203&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Ах, эта свадьба!</h3></a></li>
                <li><p>Форум для невест и ностальгирующих</p></li>
            </ul>
        </li>
        <li>
            <ul>
                <li><h2>Планирование и беременность</h2></li>
                <li><a href="forum-this-theme?this_forum_theme_order=105&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Планируем беременность</h3></a></li>
                <li><p>Форум для тех, кто пока не имеет деток,
                    но очень их хочет, а также для тех, кто имеет деток, но им все мало :)</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=110&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Беременность и роды</h3></a></li>
                <li><p>Форум посвящен будущим родителям,
                    их радостям, тревогам и вопросам</p></li>
            </ul>
        </li>

        <li>
            <ul>
                <li><h2>Все о детях</h2></li>
                <li><a href="forum-this-theme?this_forum_theme_order=115&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Детское здоровье</h3></a></li>
                <li><p>Все о здоровье наших деток.
                    Обмен опытом, информацией о врачах и медицинских центрах.
                    Отзывы о детских поликлиниках и больницах</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=120&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>О малышах до года</h3></a></li>
                <li><p>На форуме общаются мамы и папы обо всем,
                    что связано с их детьми: уход, лечение, кормление грудью, ввод прикормов, первые достижения,
                    игрушки, раннее развитие и многое другое. Хвастанье детьми приветствуется :)</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=125&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Развивающие центры, кружки и занятия</h3></a></li>
                <li><p>Всё о детских развивающих центрах и занятиях,
                    спортивных и танцевальных секциях, бассейнах для детей, творческих студиях, кружках.
                    Художественные и музыкальные школы. Центры раннего развития</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=130&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Детские сады и ясли</h3></a></li>
                <li><p>Все о Детских садах</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=135&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>От года до трех</h3></a></li>
                <li><p>Форум о детях от года до трех лет</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=140&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>От трех до шести</h3></a></li>
                <li><p>Форум о детях от 3 до 6 лет</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=145&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Младшие школьники</h3></a></li>
                <li><p>Форум для обсуждения проблем и успехов
                    начальной школы: подготовка и поступление в школу; школьные вопросы детей, родителей и педагогов;
                    медицина, психология и педагогика в семье и школе</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=150&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Подростки</h3></a></li>
                <li><p>Форум для обсуждения проблем и
                    успехов наших детей подростков</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=155&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>В десять быть дома!</h3></a></li>
                <li><p>Форум для обсуждения проблем и
                    успехов наших детей кому за трид... пятнадцать</p></li>
            </ul>
        </li>

        <li>
            <ul>
                <li><h2>Дела семейные</h2></li>
                <li><a href="forum-this-theme?this_forum_theme_order=206&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Наш дом</h3></a></li>
                <li><p>Разговоры о ремонте, мебели, быт. технике,
                    экономии, а также уют, проблемы с соседями и прочие бытовые проблемы</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=209&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Все о недвижимости</h3></a></li>
                <li><p>Обсуждение вопросов, связанных с приобретением
                    недвижимости: ипотечных кредитов, жилищных субсидий, строительных фирм, домов-новостроек.
                    Покупка, съем и строительство загородной недвижимости</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=212&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Тратим деньги</h3></a></li>
                <li><p>Про магазины, торговые центры, удачные и
                    неудачные покупки, распродажи, защита прав потребителей</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=215&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Работа и образование</h3></a></li>
                <li><p>Форум о работе и образовании для взрослых.
                    Обсуждение рабочих проблем, образовательных курсов, высшего и специального образования и пр.</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=218&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Бастен бак</h3></a></li>
                <li><p>Что-то стучит в моторе (C).
                    Разговоры об автомобилях и всем, что с ними связано</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=221&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Дачная тематика и загородная жизнь</h3></a></li>
                <li><p>Свежий воздух, птички, соседи и все такое ;)</p></li>
            </ul>
        </li>

        <li>
            <ul>
                <li><h2>Хобби и увлечения</h2></li>
                <li><a href="forum-this-theme?this_forum_theme_order=224&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Lege artis</h3></a></li>
                <li><p>Литература, искусство, история и философия.
                    Фильмы, спектакли, концерты, выставки. Творчество форумчан</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=227&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Кулинария</h3></a></li>
                <li><p>Для тех, кто любит готовить</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=230&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Рукоделие</h3></a></li>
                <li><p>Мастерицам-рукодельницам -
                    обмен опытом и хвастанье произведениями искусства</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=233&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>О домашних питомцах</h3></a></li>
                <li><p>Форум о домашних животных.
                    Уход, кормление, лечение и пр.</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=236&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Горшки и корешки</h3></a></li>
                <li><p>Флора. Дома и на даче, своими руками</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=239&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Досуг и отдых (клубы, рестораны, загородный отдых)</h3></a></li>
                <li><p>Все об отдыхе в Санкт-Петербурге и
                    Ленинградской области: рестораны, клубы, дискотеки, пансионаты, дома отдыха и пр.</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=242&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Hard and soft</h3></a></li>
                <li><p>Все что связано с компьютерами.
                    Железо, софт, доступ в интернет, фото, видео и пр.</p></li>
            </ul>
        </li>

        <li>
            <ul>
                <li><h2>Клуб путешественников</h2></li>
                <li><a href="forum-this-theme?this_forum_theme_order=245&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Финляндия - столица Швеции (с)</h3></a></li>
                <li><p>Все о Финляндии, Швеции, Норвегии и
                    странах Прибалтики</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=248&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Едем в отпуск</h3></a></li>
                <li><p>Все об организованном отдыхе и
                    поездках по путевкам. Рассказы о путешествиях</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=251&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Я сам</h3></a></li>
                <li><p>Опыт путешествий без помощи турфирм.
                    Самостоятельное бронирование отелей, билетов и пр. Рассказы о путешествиях</p></li>
            </ul>
        </li>

        <li>
            <ul>
                <li><h2>Красота, здоровье, спорт</h2></li>
                <li><a href="forum-this-theme?this_forum_theme_order=254&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Дом мод</h3></a></li>
                <li><p>Разговоры о моде, стиле, красоте.
                    Обсуждение репортажей, обзоров с fashion-событий</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=257&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Красота - страшная сила!</h3></a></li>
                <li><p>О том, как оставаться красивой и ухоженной.
                    Косметология, салоны красоты, пластическая хирургия в Петербурге.
                    Обсуждаем косметику, специалистов, процедуры. Делимся опытом</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=260&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Наше здоровье</h3></a></li>
                <li><p>Все о нашем здоровье.
                    Обмен опытом, информацией о врачах, больницах и пр.</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=263&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>О спорт, ты - жизнь!</h3></a></li>
                <li><p>Физическая культура в массы</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=266&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Похудательный форум</h3></a></li>
                <li><p>Дневники и пр. И что бы такое съесть, дабы похудеть :)</p></li>
            </ul>
        </li>

        <li>
            <ul>
                <li><h2>Болтология</h2></li>
                <li><a href="forum-this-theme?this_forum_theme_order=269&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Женские грезы</h3></a></li>
                <li><p>Если хочется выговориться,
                    поделиться радостью, найти поддержку, похвастаться или просто поразмышлять о жизни :)</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=272&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Развлечения дома</h3></a></li>
                <li><p>Обсуждение просмотренных по TV сериалов
                    и передач. Музыка. Юмор. Игры. Конкурсы. Работы в Photoshop</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=275&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Курилка</h3></a></li>
                <li><p>Мужские разговоры. Про все настоящее мужское.
                    О загадочной мужской душе</p></li>
                <li><a href="forum-this-theme?this_forum_theme_order=278&email=<%=session.getAttribute("email")%>&user_id=<%=session.getAttribute("user_id")%>"><h3>Обо всем остальном</h3></a></li>
                <li><p>Здесь обсуждаются вопросы, не вписывающиеся
                    в рамки других форумов</p></li>
            </ul>
        </li>

    </ul>

    <%--<ul>--%>
        <%--<li>--%>
            <%--<ul>--%>
                <%--<li><h2>Административный</h2></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=310&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Наш форум</h3></a></li>--%>
                <%--<li><p>Обсуждение работы форума.--%>
                    <%--Проблемы и их решения</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=320&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Конкурсы</h3></a></li>--%>
                <%--<li><p>Конкурсы для наших форумчан</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=330&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Опросник</h3></a></li>--%>
                <%--<li><p>Нам важно ваше мнение</p></li>--%>
            <%--</ul>--%>
        <%--</li>--%>

        <%--<li>--%>
            <%--<ul>--%>
                <%--<li><h2>Свадебная тематика</h2></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=203&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Ах, эта свадьба!</h3></a></li>--%>
                <%--<li><p>Форум для невест и ностальгирующих</p></li>--%>
            <%--</ul>--%>
        <%--</li>--%>
        <%--<li>--%>
            <%--<ul>--%>
                <%--<li><h2>Планирование и беременность</h2></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=105&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Планируем беременность</h3></a></li>--%>
                <%--<li><p>Форум для тех, кто пока не имеет деток,--%>
                    <%--но очень их хочет, а также для тех, кто имеет деток, но им все мало :)</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=110&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Беременность и роды</h3></a></li>--%>
                <%--<li><p>Форум посвящен будущим родителям,--%>
                    <%--их радостям, тревогам и вопросам</p></li>--%>
            <%--</ul>--%>
        <%--</li>--%>

        <%--<li>--%>
            <%--<ul>--%>
                <%--<li><h2>Все о детях</h2></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=115&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Детское здоровье</h3></a></li>--%>
                <%--<li><p>Все о здоровье наших деток.--%>
                    <%--Обмен опытом, информацией о врачах и медицинских центрах.--%>
                    <%--Отзывы о детских поликлиниках и больницах</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=120&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>О малышах до года</h3></a></li>--%>
                <%--<li><p>На форуме общаются мамы и папы обо всем,--%>
                    <%--что связано с их детьми: уход, лечение, кормление грудью, ввод прикормов, первые достижения,--%>
                    <%--игрушки, раннее развитие и многое другое. Хвастанье детьми приветствуется :)</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=125&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Развивающие центры, кружки и занятия</h3></a></li>--%>
                <%--<li><p>Всё о детских развивающих центрах и занятиях,--%>
                    <%--спортивных и танцевальных секциях, бассейнах для детей, творческих студиях, кружках.--%>
                    <%--Художественные и музыкальные школы. Центры раннего развития</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=130&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Детские сады и ясли</h3></a></li>--%>
                <%--<li><p>Все о Детских садах</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=135&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>От года до трех</h3></a></li>--%>
                <%--<li><p>Форум о детях от года до трех лет</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=140&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>От трех до шести</h3></a></li>--%>
                <%--<li><p>Форум о детях от 3 до 6 лет</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=145&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Младшие школьники</h3></a></li>--%>
                <%--<li><p>Форум для обсуждения проблем и успехов--%>
                    <%--начальной школы: подготовка и поступление в школу; школьные вопросы детей, родителей и педагогов;--%>
                    <%--медицина, психология и педагогика в семье и школе</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=150&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Подростки</h3></a></li>--%>
                <%--<li><p>Форум для обсуждения проблем и--%>
                    <%--успехов наших детей подростков</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=155&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>В десять быть дома!</h3></a></li>--%>
                <%--<li><p>Форум для обсуждения проблем и--%>
                    <%--успехов наших детей кому за трид... пятнадцать</p></li>--%>
            <%--</ul>--%>
        <%--</li>--%>

        <%--<li>--%>
            <%--<ul>--%>
                <%--<li><h2>Дела семейные</h2></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=206&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Наш дом</h3></a></li>--%>
                <%--<li><p>Разговоры о ремонте, мебели, быт. технике,--%>
                    <%--экономии, а также уют, проблемы с соседями и прочие бытовые проблемы</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=209&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Все о недвижимости</h3></a></li>--%>
                <%--<li><p>Обсуждение вопросов, связанных с приобретением--%>
                    <%--недвижимости: ипотечных кредитов, жилищных субсидий, строительных фирм, домов-новостроек.--%>
                    <%--Покупка, съем и строительство загородной недвижимости</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=212&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Тратим деньги</h3></a></li>--%>
                <%--<li><p>Про магазины, торговые центры, удачные и--%>
                    <%--неудачные покупки, распродажи, защита прав потребителей</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=215&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Работа и образование</h3></a></li>--%>
                <%--<li><p>Форум о работе и образовании для взрослых.--%>
                    <%--Обсуждение рабочих проблем, образовательных курсов, высшего и специального образования и пр.</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=218&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Бастен бак</h3></a></li>--%>
                <%--<li><p>Что-то стучит в моторе (C).--%>
                    <%--Разговоры об автомобилях и всем, что с ними связано</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=221&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Дачная тематика и загородная жизнь</h3></a></li>--%>
                <%--<li><p>Свежий воздух, птички, соседи и все такое ;)</p></li>--%>
            <%--</ul>--%>
        <%--</li>--%>

        <%--<li>--%>
            <%--<ul>--%>
                <%--<li><h2>Хобби и увлечения</h2></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=224&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Lege artis</h3></a></li>--%>
                <%--<li><p>Литература, искусство, история и философия.--%>
                    <%--Фильмы, спектакли, концерты, выставки. Творчество форумчан</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=227&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Кулинария</h3></a></li>--%>
                <%--<li><p>Для тех, кто любит готовить</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=230&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Рукоделие</h3></a></li>--%>
                <%--<li><p>Мастерицам-рукодельницам ---%>
                    <%--обмен опытом и хвастанье произведениями искусства</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=233&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>О домашних питомцах</h3></a></li>--%>
                <%--<li><p>Форум о домашних животных.--%>
                    <%--Уход, кормление, лечение и пр.</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=236&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Горшки и корешки</h3></a></li>--%>
                <%--<li><p>Флора. Дома и на даче, своими руками</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=239&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Досуг и отдых (клубы, рестораны, загородный отдых)</h3></a></li>--%>
                <%--<li><p>Все об отдыхе в Санкт-Петербурге и--%>
                    <%--Ленинградской области: рестораны, клубы, дискотеки, пансионаты, дома отдыха и пр.</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=242&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Hard and soft</h3></a></li>--%>
                <%--<li><p>Все что связано с компьютерами.--%>
                    <%--Железо, софт, доступ в интернет, фото, видео и пр.</p></li>--%>
            <%--</ul>--%>
        <%--</li>--%>

        <%--<li>--%>
            <%--<ul>--%>
                <%--<li><h2>Клуб путешественников</h2></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=245&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Финляндия - столица Швеции (с)</h3></a></li>--%>
                <%--<li><p>Все о Финляндии, Швеции, Норвегии и--%>
                    <%--странах Прибалтики</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=248&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Едем в отпуск</h3></a></li>--%>
                <%--<li><p>Все об организованном отдыхе и--%>
                    <%--поездках по путевкам. Рассказы о путешествиях</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=251&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Я сам</h3></a></li>--%>
                <%--<li><p>Опыт путешествий без помощи турфирм.--%>
                    <%--Самостоятельное бронирование отелей, билетов и пр. Рассказы о путешествиях</p></li>--%>
            <%--</ul>--%>
        <%--</li>--%>

        <%--<li>--%>
            <%--<ul>--%>
                <%--<li><h2>Красота, здоровье, спорт</h2></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=254&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Дом мод</h3></a></li>--%>
                <%--<li><p>Разговоры о моде, стиле, красоте.--%>
                    <%--Обсуждение репортажей, обзоров с fashion-событий</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=257&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Красота - страшная сила!</h3></a></li>--%>
                <%--<li><p>О том, как оставаться красивой и ухоженной.--%>
                    <%--Косметология, салоны красоты, пластическая хирургия в Петербурге.--%>
                    <%--Обсуждаем косметику, специалистов, процедуры. Делимся опытом</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=260&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Наше здоровье</h3></a></li>--%>
                <%--<li><p>Все о нашем здоровье.--%>
                    <%--Обмен опытом, информацией о врачах, больницах и пр.</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=263&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>О спорт, ты - жизнь!</h3></a></li>--%>
                <%--<li><p>Физическая культура в массы</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=266&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Похудательный форум</h3></a></li>--%>
                <%--<li><p>Дневники и пр. И что бы такое съесть, дабы похудеть :)</p></li>--%>
            <%--</ul>--%>
        <%--</li>--%>

        <%--<li>--%>
            <%--<ul>--%>
                <%--<li><h2>Болтология</h2></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=269&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Женские грезы</h3></a></li>--%>
                <%--<li><p>Если хочется выговориться,--%>
                    <%--поделиться радостью, найти поддержку, похвастаться или просто поразмышлять о жизни :)</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=272&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Развлечения дома</h3></a></li>--%>
                <%--<li><p>Обсуждение просмотренных по TV сериалов--%>
                    <%--и передач. Музыка. Юмор. Игры. Конкурсы. Работы в Photoshop</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=275&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Курилка</h3></a></li>--%>
                <%--<li><p>Мужские разговоры. Про все настоящее мужское.--%>
                    <%--О загадочной мужской душе</p></li>--%>
                <%--<li><a href="forum-this-theme?this_forum_theme_order=278&email=<%=request.getParameter("email")%>&user_id=<%=request.getParameter("user_id")%>"><h3>Обо всем остальном</h3></a></li>--%>
                <%--<li><p>Здесь обсуждаются вопросы, не вписывающиеся--%>
                    <%--в рамки других форумов</p></li>--%>
            <%--</ul>--%>
        <%--</li>--%>

    <%--</ul>--%>

</section>

</body>
</html>
