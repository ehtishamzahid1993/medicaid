function showRowEdit(key) {
	try {
		$(".rowEdit_" + key + " .ui-icon-pencil").click();
		$(".editBtn_" + key).hide();
		$(".rowEdit_" + key + " .ui-icon-check").attr("onclick",
				"clickRowEdit('" + key + "')");
		$(".rowEdit_" + key + " .ui-icon-close").attr("onclick",
				"clickRowEdit('" + key + "')");
		$(".saveBtn_" + key).show();
	} catch (e) {
		console.error(e);
	}
}

function clickRowEdit(key) {
	try {
		console.log("clickRowEdit");
		$(".editBtn_" + key).show();
	} catch (e) {
		console.error(e);
	}
}

function saveRowEdit(key, icon) {
	try {
		console.log("saveRowEdit");
		$(".rowEdit_" + key + " .ui-icon-" + icon).click();
		$(".saveBtn_" + key).hide();
	} catch (e) {
		console.error(e);
	}
}
