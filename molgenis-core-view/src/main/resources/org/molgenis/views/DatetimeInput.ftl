<#macro datetime id name date required=false>
<div id="${id}" class="input-append date"  data-date="${date}">
	<input name="${name}" size="16" type="text" readonly />
	<#if !required><span class="add-on"><i class="icon-remove"></i></span></#if>
	<span class="add-on"><i class="icon-th"></i></span>
</div>
<script type="text/javascript">$("#${id}").datetimepicker({format: 'mm/dd/yyyy hh:ii', autoclose: true, minuteStep: 1});</script>
</#macro>