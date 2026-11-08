using TMPro;
using UnityEngine;

public class ForInteraction : Interaction
{
    public TextMeshPro text;

    int hoverCount = 0;
    int selectedCount = 0;
    int activatedCount = 0;
    override protected void HoverEnter()
    {
        hoverCount++;
        Set();
    }

    override protected void HoverExit()
    {
        hoverCount--;
        Set();
    }

    override protected void SelectEnter()
    {
        selectedCount++;
        Set();
    }

    override protected void SelectExit()
    {
        selectedCount--;
        Set();
    }

    override protected void Activate()
    {
        activatedCount++;
        Set();
    }

    override protected void Deactivate()
    {
        activatedCount--;
        Set();
    }

    void Set()
    {
        text.text =
            "Hovering: " + (hoverCount > 0 ? "YES\n" : "NO\n") +
            "Selected: " + (selectedCount > 0 ? "YES\n" : "NO\n") +
            "Activated: " + (activatedCount > 0 ? "YES" : "NO");
    }

}
