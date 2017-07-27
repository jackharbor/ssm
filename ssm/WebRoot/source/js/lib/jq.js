var jq={
	/**
	 * 控制台输出
	 * @param msg
	 */
	log : function(msg){
		console.log(msg);
	},
	
	/**
	 * 判断是否为空
	 * @param value
	 * @returns {Boolean}
	 */
	isNull : function(value) {
		if (value == null || value == undefined || value == "") {
			return true;
		}
		return false;
	},
	
	/**
	 * 封装的ajax提交
	 * @param url
	 * @param data
	 * @param successFunc
	 * @param async
	 */
	ajax : function(url, data, successFunc, config) {
		var defType = 'POST';
		var defAsync = false;
		var defDataType = 'json';
		if (config) {
			if(config.type) defType = config.type;
			if(config.async) defAsync = config.async;
			if(config.dataType) defDataType = config.dataType;
		};
		$.ajax({
			type : defType,
			url : url,
			data : data,
			async : defAsync,
			dataType : defDataType,
			success : function(redata) {
				if(successFunc){
					if('error' in redata){
						alert("redata.error");
					}else{
						successFunc.call(successFunc, redata);
					}
				}
			},
			error : function() {
				alert('系统错误,操作失败');
			}
		});
	},
	
	/***
	 * 提交表单form
	 * @param url
	 * @param formName
	 * @param successFunc
	 * @param exParam->&param1=value&param2=value
	 */
	formSubmit : function(url, formID, successFunc, exParam) {
		var form = $('#' + formID);
		var data = form.serialize();
		if (exParam) {
			data += exParam;
		}
		this.ajax(url, data, successFunc);
	},
	
	/***
	 * 使用form提交（下载文件的提交）
	 * @param url
	 * @param data
	 */
	useFormSubmit : function(url,data,config){
		var defMethod = 'POST';
		var defTarget = '';
		if (config) {
			if(config.method) defMethod = config.method;
			if(config.target) defTarget = config.target;
		};
		var form=$('<form></form>');
		form.attr('action',url);
		form.attr('method',defMethod);
		form.attr('target',defTarget);
		$.each(data,function(name,value){
			var input=$("<input type='hidden' name="+name+" />");
			input.attr('value',value);
			form.append(input);
		});
		form.appendTo('body');
		form.css('display','none');
		form.submit();
		form.remove();
	},
	
};