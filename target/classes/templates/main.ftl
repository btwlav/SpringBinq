<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div>
        <@l.logout/>
    </div>
    <div>
        <form method="post" action="/addStudent">
            <label>Fio<input type="text" name="fio" placeholder="Type student fio"/></label>
            <label>Group
                <select name="groupName">
                    <#list groups as group>
                        <option value="${group.groupName}">${group.groupName}</option>
                    </#list>
                </select>
            </label>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit">Insert</button>
        </form>
    </div>
    <div>
        <form method="get" action="/">
            <input type="text" name="fioFilter"/>
            <button type="submit">Find</button>
        </form>
    </div>
    <label>Students list</label>
    <#list students as student>
        <div>
            <b>${student.id}</b>
            <span>${student.fio}</span>
            <span>${student.stringBdate}</span>

            <strong>${student.groupName}</strong>
        </div>
    <#else>
        No students
    </#list>
</@c.page>