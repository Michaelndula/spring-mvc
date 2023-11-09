<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Tours</title>
</head>
<body>
    <h1>List of Availbale tours</h1>
    <div>
        <table th:if="${!tours.empty}">
            <tr>
                <td>Name</td>
                <td>Code</td>
                <td>Continent</td>
                <td>Date</td>
                <td>Duration</td>
                <td>All Inclusive</td>
            </tr>
            <tr th:each="tour: ${tours}">
                <td th:text="{tour.name}"></td>
                <td th:text="{tour.code}"></td>
                <td th:text="{tour.continent}"></td>
                <td th:text="{tour.date}"></td>
                <td th:text="{tour.duration}"></td>
                <td th:text="{tour.allInclusive}"></td>
            </tr>
        </table>
        <span th:if="${tours.empty}">No tours currently available, check back later</span>
    </div>
    <p>
        <a th:href="@{/}"> << Back </a>
    </p>
</body>
</html>