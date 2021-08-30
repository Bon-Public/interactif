extends RichTextLabel

signal text_fully_visible

func _process(delta):
	if visible_characters >= text.length():
		emit_signal("text_fully_visible")
