extends Button

var next_id

signal response_clicked

func _enter_tree():
	connect("pressed", self, "response_clicked")

func response_clicked():
	emit_signal("response_clicked", next_id)
