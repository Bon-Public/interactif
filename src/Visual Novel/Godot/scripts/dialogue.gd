extends Control

export (PackedScene) var response

var currentDialogue:DialogueLine

const DISPLAY_SPEED = 20 # characters per second

func _ready():
	DialogueManager.resource = preload("res://text/dialogue.tres")
	DialogueManager.game_state = self
	
	next_line("796b8e70-78c0-4138-ac7e-a5a75ea51de2")

func _input(event):
	if event.is_action_pressed("ui_accept") and currentDialogue.type == "dialogue" and currentDialogue.responses.size() == 0:
		next_line(currentDialogue.next_node_id)

func next_line(next_id):
	currentDialogue = yield(DialogueManager.get_next_dialogue_line(next_id), "completed")
	if currentDialogue == null: 
		return
	
	$line.text = currentDialogue.dialogue
	$line/tween.stop($line, "visible_characters")
	$line.visible_characters = 0
	$line/tween.interpolate_property(
		$line, "visible_characters", 
		0, currentDialogue.dialogue.length(), 
		currentDialogue.dialogue.length() / DISPLAY_SPEED
	)
	$line/tween.start()
	
	if currentDialogue.responses and currentDialogue.responses.size() > 0:
		populate_responses(currentDialogue.responses)

func populate_responses(responses_objects):
	$responses.hide()
	for dialogue_response in responses_objects:
		var r = response.instance()
		r.text = dialogue_response.prompt
		$responses.add_child(r)
		r.next_id = dialogue_response.next_node_id
		r.connect("response_clicked", self, "on_response_clicked")

func on_response_clicked(next_id):
	clear_responses()
	if next_id == null or next_id == "":
		end()
	else:
		next_line(next_id)

func clear_responses():
	for r in $responses.get_children():
		r.queue_free()

func end():
	print("END")
	clear_responses()
	$line.text = ""
	$line.hide()

func _on_line_text_fully_visible():
	$responses.show()
