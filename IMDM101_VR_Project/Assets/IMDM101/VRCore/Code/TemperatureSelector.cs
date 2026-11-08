using UnityEngine;
using UnityEngine.UI;

public class TemperatureSelector : MonoBehaviour
{
    [Header("Buttons")]
    public Button hotButton;
    public Button coldButton;

    [Header("Button Images")]
    public Image hotImage;
    public Image coldImage;

    [Header("XR Rig")]
    public Transform xrRig;

    [Header("Teleport Points")]
    public Transform hotTeleportPoint;
    public Transform coldTeleportPoint;

    [Header("Button Colors")]
    public Color normalColor = Color.white;
    public Color selectedColor = new Color(0.7f, 0.7f, 1f);

    private string currentSelection = "";

    void Start()
    {
        // Button click listeners
        hotButton.onClick.AddListener(SelectHot);
        coldButton.onClick.AddListener(SelectCold);

        // Set default colors
        UpdateButtonColors();
    }

    public void SelectHot()
    {
        currentSelection = "Hot";
        UpdateButtonColors();
    }

    public void SelectCold()
    {
        currentSelection = "Cold";
        UpdateButtonColors();
    }

    void UpdateButtonColors()
    {
        // Hot button color
        if (currentSelection == "Hot")
            hotImage.color = selectedColor;
        else
            hotImage.color = normalColor;

        // Cold button color
        if (currentSelection == "Cold")
            coldImage.color = selectedColor;
        else
            coldImage.color = normalColor;
    }

    public void ConfirmSelection()
    {
        if (xrRig == null) return;

        // Get headset/camera position
        Transform cameraTransform = Camera.main.transform;

        // Calculate XR offset
        Vector3 offset = xrRig.position - cameraTransform.position;

        // Ignore vertical offset
        offset.y = 0f;

        // Teleport based on selection
        if (currentSelection == "Hot" && hotTeleportPoint != null)
        {
            xrRig.position = hotTeleportPoint.position + offset;
        }
        else if (currentSelection == "Cold" && coldTeleportPoint != null)
        {
            xrRig.position = coldTeleportPoint.position + offset;
        }
    }
}