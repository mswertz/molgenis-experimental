<#-- see http://twitter.github.com/bootstrap/components.html#navs -->
<div class="tabbable">
	<ul class="nav nav-tabs">
<#foreach item in model.items><#if item.id == model.active>  
    	<li class="active"><a href="${item.href}"<#if item.contents?exists>data-toggle="tab"</#if>>${item.label}</a></li>
<#else>
    	<li><a href="${item.href}" <#if item.contents?exists>data-toggle="tab"</#if>>${item.label}</a></li>
</#if></#foreach>
	</ul>
	<div class="tab-content">
<#foreach item in model.items><#if item.contents?exists>
		<div class="tab-pane<#if item.id == model.active> active</#if>" id="${item.id}">
		${item.contents}
		</div>
</#if></#foreach>
	</div>
</div>