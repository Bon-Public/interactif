extends RichTextLabel

var charactersAllVisible = false

signal text_fully_visible

func _process(delta):
	if visible_characters >= text.length() and not charactersAllVisible:
		charactersAllVisible = true
		emit_signal("text_fully_visible")

func reset_line():
	charactersAllVisible = false

func set_text(s)->void:
	reset_line()
	.set_text(s)
