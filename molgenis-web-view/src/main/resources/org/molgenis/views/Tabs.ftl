<#macro tabs id active items>
<ul id="${id}" class="nav nav-tabs">
<#list items as item>
  <li class="<#if item == active>active</#if>"><a data-target="#${item.getId()}" data-toggle="tab" href="${item.getHref()}" onclick="var target=$(event.target);var container=$(target.attr('data-target'));if(container.is(':empty')){container.load(target.attr('href'));};window.history.pushState(null, null, target.attr('href'));">${item.getLabel()}</a></li>
</#list>
</ul>
<div class="tab-content">
<#list items as item>
<#if active == item>
<div id="${item.getId()}" class="tab-pane active">
<script>$('#${item.getId()}').load('${item.getHref()}');</script>
</div>
<#else>
<div id="${item.getId()}" class="tab-pane"></div>
</#if>
</#list>
</div>
</#macro>