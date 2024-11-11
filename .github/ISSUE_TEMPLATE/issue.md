name: Issue Template
description: If you have any problem with the mod working, you should select this template.

body:
  - type: checkboxes
    id: i-am-not-an-idiot-check
    attributes:
      label: Required confirmation
      description: Please confirm that you have provided logs AND are sure this issue is not known
      options:
        - label: 
          required: true
    validations:
      required: true
  - type: input
    id: mod-version
    attributes:
      label: Mod version
      description: Enter your Windows version. For Windows 10 and 11 include build/update number.
      placeholder: ex. Windows 10 20H2
    validations:
      required: true
  - type: checkboxes
    id: other-mods
    attributes:
      label: Other mods
      description: Check this box if you have any other mods installed than Temporal Additions (And it's dependencies)
  - type: textarea
    id: issue-description
    attributes:
      label: Describe the issue
      description: Please describe the issue you have with the mod, and steps on how to replicate it
      placeholder: You can attach screenshots here if necessary
    validations:
      required: true